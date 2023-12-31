package com.recipes.application.views.recipe;

import com.recipes.application.data.model.Recipe.Recipe;
import com.recipes.application.data.repository.recipe.RecipeJdbcRepository;
import com.recipes.application.views.MainLayout;
import com.recipes.application.views.components.ImageListViewCard;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.MaxWidth;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@PageTitle("Minhas Receitas")
@Route(value = "/", layout = MainLayout.class)
@Uses(Icon.class)
public class MyRecipesView extends Main implements HasComponents, HasStyle {

    private OrderedList imageContainer;

    private Button createRecipe;

    private RecipeJdbcRepository repository = new RecipeJdbcRepository();

    public MyRecipesView() throws SQLException {
        constructUI();

        List<Recipe> recipeList = repository.findAll();
        renderRecipeList(recipeList);
    }

    private void renderRecipeList(List<Recipe> recipeList) throws SQLException {
        imageContainer.removeAll();
        for (Recipe recipe : recipeList) {
            imageContainer.add(new ImageListViewCard(
                    recipe.getTitle(),
                    recipe.getImage(),
                    recipe.getDescription(),
                    recipe.getId()
            ));
        }

        if (recipeList.isEmpty()) {
            createRecipe = new Button("Cadastre sua primeira receita!");
            imageContainer.add(createRecipe);

            createRecipe.addClickListener(event -> {
                UI.getCurrent().navigate(RecipeFormView.class);
            });
        }
    }

    private void constructUI() {
        addClassNames("image-list-view");
        addClassNames(MaxWidth.SCREEN_LARGE, Margin.Horizontal.AUTO, Padding.Bottom.LARGE, Padding.Horizontal.LARGE);

        HorizontalLayout container = new HorizontalLayout();
        container.addClassNames(AlignItems.CENTER, JustifyContent.BETWEEN);

        VerticalLayout headerContainer = new VerticalLayout();
        H3 header = new H3("Minhas Receitas");
        header.addClassNames(Margin.Bottom.NONE, Margin.Top.XLARGE, FontSize.XXXLARGE);
        Paragraph description = new Paragraph("Suas receitas em um só lugar!");
        description.addClassNames(Margin.Bottom.XLARGE, Margin.Top.NONE, TextColor.SECONDARY);
        headerContainer.add(header, description);

        Select<String> sortBy = new Select<>();
        sortBy.setLabel("Filtrar por");
        sortBy.setItems("Todos", "Favoritos");
        sortBy.setValue("Todos");
        sortBy.addValueChangeListener(event -> {
            try {
                String selectedFilter = event.getValue();
                updateUIBasedOnFilter(selectedFilter);
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao filtrar por registros " + e);
            }
        });

        imageContainer = new OrderedList();
        imageContainer.addClassNames(LumoUtility.Gap.MEDIUM, LumoUtility.Display.GRID, LumoUtility.ListStyleType.NONE, Margin.NONE, Padding.NONE);

        container.add(headerContainer, sortBy);
        add(container, imageContainer);
    }

    private void updateUIBasedOnFilter(String selectedFilter) throws SQLException {
        List<Recipe> recipeList = null;

        if (Objects.equals(selectedFilter, "Todos")) recipeList = repository.findAll();
        if (Objects.equals(selectedFilter, "Favoritos")) recipeList = repository.findAllFavorites();

        renderRecipeList(recipeList);
    }
}

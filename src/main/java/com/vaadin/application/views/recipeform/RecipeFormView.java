package com.vaadin.application.views.recipeform;

import com.vaadin.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Recipe Register")
@Route(value = "recipe-form", layout = MainLayout.class)
@Uses(Icon.class)
public class RecipeFormView extends Composite<VerticalLayout> {

    public RecipeFormView() {

        H3 title = new H3("Recipe Register");

        TextField recipeName = new TextField("Recipe Name:");
        TextField recipeTime = new TextField("Time to prepare:");
        TextField recipeIngredients = new TextField("Ingredients:");
        TextField recipePreparation = new TextField("Preparation process:");

        Button button = new Button("Save");

        VerticalLayout page = new VerticalLayout();

        HorizontalLayout header = new HorizontalLayout();
            header.add(title);

        HorizontalLayout body = new HorizontalLayout();

            VerticalLayout bodyColumn1 = new VerticalLayout();
                bodyColumn1.add(recipeName);
                bodyColumn1.add(recipeIngredients);

            VerticalLayout bodyColumn2 = new VerticalLayout();
                bodyColumn2.add(recipeTime);
                bodyColumn2.add(recipePreparation);

            body.add(bodyColumn1,bodyColumn2);

        HorizontalLayout footer = new HorizontalLayout();
            footer.add(button);

        page.add(header,body,footer);

        getContent().add(page);




    }
}

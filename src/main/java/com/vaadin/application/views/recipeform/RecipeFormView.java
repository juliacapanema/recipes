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
        TextField recipeName = new TextField("Name:");
        TextField recipeDescription = new TextField("Description:");
        Button button = new Button("Next");

        VerticalLayout column1 = new VerticalLayout();
        HorizontalLayout line1 = new HorizontalLayout();
        HorizontalLayout line2 = new HorizontalLayout();
        HorizontalLayout line3 = new HorizontalLayout();

        line1.add(title);
        line2.add(recipeName, recipeDescription);
        line3.add(button);
        column1.add(line1,line2,line3);

        getContent().add(column1);


    }
}

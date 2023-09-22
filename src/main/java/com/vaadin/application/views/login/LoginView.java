package com.vaadin.application.views.login;

import com.vaadin.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Login")
@Route(value = "login", layout = MainLayout.class)
public class LoginView extends Composite<VerticalLayout> {

    public LoginView() {
        VerticalLayout layoutColumn = new VerticalLayout();

        HorizontalLayout layoutRow = new HorizontalLayout();
        H3 h3 = new H3("Vaaddin projeto de POO");

        HorizontalLayout layoutRow2 = new HorizontalLayout();
        EmailField emailField = new EmailField("E-mail");

        HorizontalLayout layoutRow3 = new HorizontalLayout();
        PasswordField passwordField = new PasswordField("Senha");

        HorizontalLayout layoutRow4 = new HorizontalLayout();
        Button loginButton = new Button("Entrar");
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        getContent().setWidthFull();
        getContent().addClassName(LumoUtility.Padding.LARGE);

        layoutColumn.setWidth(null);

        layoutColumn.add(layoutRow);
        layoutColumn.add(layoutRow2);
        layoutColumn.add(layoutRow3);
        layoutColumn.add(layoutRow4);

        layoutRow.setWidthFull();
        layoutRow.setFlexGrow(1.0, layoutColumn);
        layoutRow.add(h3);

        layoutRow2.setWidthFull();
        layoutRow2.setFlexGrow(1.0, layoutColumn);
        layoutRow2.add(emailField);

        layoutRow3.setWidthFull();
        layoutRow3.setFlexGrow(1.0, layoutColumn);
        layoutRow3.add(passwordField);

        layoutRow4.setWidthFull();
        layoutRow4.setFlexGrow(1.0, layoutColumn);
        layoutRow4.add(loginButton);

        getContent().add(layoutColumn);
    }
}

package com.vaadin.application.views.login;

import com.vaadin.application.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Login")
@Route(value = "logi", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class LoginView extends HorizontalLayout {


}

package com.vaadin.application.model;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private String description;
    private List<Ingredient> ingredients = new ArrayList<>();
    private Preparation preparation;

}

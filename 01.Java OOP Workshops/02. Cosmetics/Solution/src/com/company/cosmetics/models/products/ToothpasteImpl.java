package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Toothpaste;
import com.company.cosmetics.models.common.GenderType;


import java.util.ArrayList;
import java.util.List;

public class ToothpasteImpl extends ProductBase implements Toothpaste {


    private List<String> ingredients;
    public ToothpasteImpl(String name, String brand, double price, GenderType gender, List<String> ingredients) {
        super(name, brand, price, gender);
        if (ingredients == null) {
            throw new IllegalArgumentException();
        }
        this.ingredients = ingredients;
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder(super.print());
        sb.append("\n #Ingredients: ").append(ingredients).append("\n ===");
        return sb.toString();
    }


    @Override
    public List<String> getIngredients() {
        return new ArrayList<>(ingredients);
    }
}

package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Toothpaste;
import com.company.cosmetics.models.common.GenderType;


import java.util.List;

public class ToothpasteImpl extends ProductBase implements Toothpaste {
    private List<String> ingredients;
    
    public ToothpasteImpl(String name, String brand, double price, GenderType gender, List<String> ingredients) {
        super(name, brand, price, gender);
        setIngredients(ingredients);
    }

    @Override
    public String print() {
        String output = String.format("#%s %s \n" +
                        " #Price: $%.2f\n" +
                        " #Gender: %s\n" +
                        " #Ingredients: %s", getName(), getBrand(), getPrice(), getGender(),
                getIngredients());

        return output;
    }

    @Override
    public List<String> getIngredients() {
        return ingredients;
    }
    public void setIngredients(List<String> ingredients) {
        if (ingredients == null) {
            throw new IllegalArgumentException("The ingredient cannot be null");
        }
        this.ingredients = ingredients;
    }
}

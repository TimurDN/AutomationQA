package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Cream;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.ScentType;


public class CreamImpl extends ProductBase implements Cream {
    private ScentType scent;
    
    public CreamImpl(String name, String brand, double price, GenderType gender, ScentType scent) {
        super(name, brand, price,gender);
        setScent(scent);
    }

    @Override
    public String print() {
        String output = String.format("#%s %s \n" +
                        " #Price: $%.2f\n" +
                        " #Gender: %s\n" +
                        " #Scent: %s", getName(), getBrand(), getPrice(), getGender(),
                getScent().name()); //because of enum

        return output;
    }

    @Override
    public ScentType getScent() {
        return scent;
    }

    public void setScent(ScentType scent) {
        if (scent == null) {
            throw new IllegalArgumentException("Scent type cannot be null");

        }
        this.scent = scent;
    }
}

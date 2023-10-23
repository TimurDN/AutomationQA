package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Shampoo;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.UsageType;


public class ShampooImpl extends ProductBase implements Shampoo {
    private int milliliters;
    private UsageType usage;
    
    public ShampooImpl(String name, String brand, double price, GenderType gender, int milliliters, UsageType usage) {
        super(name, brand, price, gender);
        setMilliliters(milliliters);
        setUsage(usage);
    }



    public void setMilliliters(int milliliters) {
        if (milliliters < 0.0) {
            throw new IllegalArgumentException("Milliliters cannot be negative number");
        }
        this.milliliters = milliliters;
    }

    public void setUsage(UsageType usage) {
        if (usage == null) {
            throw new IllegalArgumentException("Usage type cannot be null");
        }
        this.usage = usage;
    }

    @Override
    public String print() {
        String output = String.format("#%s %s \n" +
                        " #Price: $%.2f\n " +
                        " #Gender: %s\n" +
                        " #Milliliters: %d\n" +
                        " #Usage: %s", getName(), getBrand(), getPrice(), getGender(),
                getMilliliters(), getUsage().name());
        return output;
    }

    @Override
    public int getMilliliters() {
        return milliliters;
    }

    @Override
    public UsageType getUsage() {
        return usage;
    }
}

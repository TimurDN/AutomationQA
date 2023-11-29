package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Shampoo;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.UsageType;


public class ShampooImpl extends ProductBase implements Shampoo {

    private int milliliters;
    private UsageType usageType;
    public ShampooImpl(String name, String brand, double price, GenderType gender, int milliliters, UsageType usage) {
        super(name, brand, price, gender);
        setMilliliters(milliliters);
        usageType = usage;
    }
    public String print() {
        return super.print() +
                String.format("\n #Milliliters: %d\n #Usage: %s\n ===", getMilliliters(), getUsage().toString());
    }

    @Override
    public int getMilliliters() {
        return milliliters;
    }

    @Override
    public UsageType getUsage() {
        return usageType;
    }

    private void setMilliliters(int milliliters) {
        if (milliliters <= 0) {
            throw new IllegalArgumentException();
        }
        this.milliliters = milliliters;
    }
}

package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Cream;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.ScentType;


public class CreamImpl extends ProductBase implements Cream {

    private ScentType scent;
    
    public CreamImpl(String name, String brand, double price, GenderType gender, ScentType scentType) {
        super(name, brand, price, gender);
        scent = scentType;
    }

    @Override
    public String print() {
        return super.print() + "\n #Scent: " + scent + "\n ===";
    }

    @Override
    public ScentType getScent() {
        return scent;
    }
}

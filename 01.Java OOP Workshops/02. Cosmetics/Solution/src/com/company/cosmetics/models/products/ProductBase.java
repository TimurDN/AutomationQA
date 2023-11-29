package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.common.GenderType;


public class ProductBase implements Product {

    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 10;
    private static final int BRAND_MIN_LENGTH = 2;
    private static final int BRAND_MAX_LENGTH = 10;
    private static final int PRICE_MIN_VALUE = 0;
    private String name;
    private String brand;
    private double price;
    private GenderType gender;

    public ProductBase(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        setGender(gender);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public GenderType getGender() {
        return gender;
    }

    @Override
    public String print() {
        return String.format("#%s %s\n #Price: $%.2f\n #Gender: %s",
                getName(), getBrand(), getPrice(), getGender().toString());
    }


    private void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    private void setBrand(String brand) {
        if (brand == null) {
            throw new IllegalArgumentException();
        }
        if (brand.length() < BRAND_MIN_LENGTH || brand.length() > BRAND_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.brand = brand;
    }

    private void setPrice(double price) {
        if (price < PRICE_MIN_VALUE) {
            throw new IllegalArgumentException();
        }
        this.price = price;
    }

    private void setGender(GenderType gender) {
        if (gender == null) {
            throw new IllegalArgumentException();
        }
        this.gender = gender;
    }
}

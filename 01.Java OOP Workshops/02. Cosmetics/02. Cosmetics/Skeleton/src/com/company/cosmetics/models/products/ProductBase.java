package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.common.GenderType;

import java.util.Arrays;

//toString override anlamadım
public class ProductBase implements Product {

    public static final int MIN_PROD_NAME_LENGTH = 3;
    public static final int MAX_PROD_NAME_LENGTH = 10;
    public static final int MIN_BRAND_NAME_LENGTH = 2;
    public static final int MAX_BRAND_NAME_LENGTH = 10;
    private String name;
    private String brand;
    private double price;
    private GenderType gender;

    //Finish the class
    //What variables, what constants should you write here?
    //validate


    protected ProductBase(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        setGender(gender);
    }

    public void setName(String name) {
        if (name == null || name.length() < MIN_PROD_NAME_LENGTH
                || name.length() > MAX_PROD_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    "Product name cannot be null and can be 3 to 10 chars.");
        }
        this.name = name;
    }


    public void setBrand(String brand) {
        if (brand == null || brand.length() < MIN_BRAND_NAME_LENGTH
                || brand.length() > MAX_BRAND_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    "Brand name cannot be null and can be 2 to 10 chars.");
        }
        this.brand = brand;
    }

    public void setPrice(double price) {
        if (price < 0.0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public void setGender(GenderType gender) {
        if (gender == null){
            throw new IllegalArgumentException("Gender cannot be null"); // how to write if(GenderType.equals/valuesof)

        }
        this.gender = gender;

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public GenderType getGender() {
        return this.gender;
    }

    @Override
    public String print() {
       return String.format("with name %s was created!", getName());
    }
}

package com.company.cosmetics.models;


import com.company.cosmetics.models.contracts.Category;
import com.company.cosmetics.models.contracts.Product;


import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements Category {
    public static final int NAME_MIN_LENGTH = 2;
    public static final int NAME_MAX_LENGTH = 15;
    //use constants for validations values
    
    private String name;
    private List<Product> products;
    
    public CategoryImpl(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        products = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public List<Product> getProducts() {
        //users of this class should not be able to modify the products collection via the getter!
        return new ArrayList<>(products);
    }

    
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }
        products.add(product);
    }
    
    public void removeProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }
        if (!products.contains(product)) {
            throw new IllegalArgumentException();
        }
        products.remove(product);
    }

    public String print() {
        if (products.size() == 0) {
            return String.format("#Category: %s\n" +
                    " #No product in this category", name);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("#Category: %s\n", name));
        for (Product product : products) {
            stringBuilder.append(product.print());
        }
        return stringBuilder.toString();
    }
    
}

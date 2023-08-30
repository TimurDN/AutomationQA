package com.company.cosmetics.models;


import com.company.cosmetics.models.contracts.Category;
import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.contracts.Shampoo;
import com.company.cosmetics.models.contracts.Toothpaste;
import com.company.cosmetics.models.products.ShampooImpl;


import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements Category {
    //use constants for validations values

    private String name;
    private List<Product> products;

    public CategoryImpl(String name) {
        setName(name);
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 2 || name.length() > 15) {
            throw new IllegalArgumentException("Category name should be between 2 and 15 chars.");
        }
        this.name = name;
    }

    public List<Product> getProducts() {
        //todo why are we returning a copy? Replace this comment with explanation!
        //Eğer products değişkenini direkt döndürürsek kategori objektinin dışında da
        // bu listenin üzerinde değişiklik yapılmasına izin vermiş oluruz. Ancak kopyasını geriye gönderirsek, kategori dışında kategorinin listesi üzerinde değişiklik
        //yapılamaz.
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        products.add(product);
    }

    public void removeProduct(Product product) {
        Product temp = null;

        for (Product p : products) {
            if (p.getName().equals(product.getName())) {
                temp = p;
                break;
            }
        }
        if (temp != null) {
            products.remove(temp);

        } else {
            throw new IllegalArgumentException("Product was not found.");
        }

    }

    //The engine calls this method to print your category! You should not rename it!
    public String print() {
        if (products.size() == 0) {
            return String.format("#Category: %s\n" +
                    " #No product in this category", name);
        }

        //finish ProductBase class before implementing this method

        String output = "#Category: " + getName() + "\n";

        for (Product p : products) {
            output += p.print() + "\n === \n";
        }
        return output;
    }
}

//#Category: Shampoos
//#MyMan Nivea
// #Price: $10.99
// #Gender: Men
// #Milliliters: 1000
// #Usage: EveryDay
// ===
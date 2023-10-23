package com.company.cosmetics;

import com.company.cosmetics.core.CosmeticsEngine;
import com.company.cosmetics.models.CategoryImpl;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.ScentType;
import com.company.cosmetics.models.common.UsageType;
import com.company.cosmetics.models.contracts.Category;
import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.products.CreamImpl;
import com.company.cosmetics.models.products.ShampooImpl;
import com.company.cosmetics.models.products.ToothpasteImpl;

import java.util.Arrays;

public class Startup {
    
    public static void main(String[] args) {
//        CosmeticsEngine engine = new CosmeticsEngine();
//        engine.start();

        Product p1 = new CreamImpl("MyMan", "Nivea", 10.99, GenderType.MEN, ScentType.LAVENDER);
        Product p2 = new ShampooImpl("MyMan", "Nivea", 10.99, GenderType.MEN, 1000, UsageType.EVERYDAY);
        Product p3 = new ToothpasteImpl("MyMan", "Nivea", 10.99, GenderType.MEN, Arrays.asList("A","B","C"));
        Category C = new CategoryImpl("Products");
      //  System.out.println(p1.print() + "\n === \n" + p2.print());
        C.addProduct(p1);
        C.addProduct(p2);
        C.addProduct(p3);
        System.out.println(C.print());
    }

}

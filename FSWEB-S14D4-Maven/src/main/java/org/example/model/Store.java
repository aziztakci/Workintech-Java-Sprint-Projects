package org.example.model;

public class Store {
    public static void main(String[] args) {

        ProductForSale[] products = new ProductForSale[3];

        products[0] = new Chocolate("Sweet", 15.0, "Milk Chocolate", true);
        products[1] = new Coke("Drink", 25.0, "Zero Sugar", true);
        products[2] = new Bread("Food", 10.0, "Whole Wheat", true);


        listProducts(products);
    }

    public static void listProducts(ProductForSale[] products) {
        for(ProductForSale product: products) {
            product.showDetails();
        }
    }
}
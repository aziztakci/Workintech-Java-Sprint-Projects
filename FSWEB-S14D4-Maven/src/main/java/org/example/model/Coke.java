package org.example.model;

public class Coke  extends  ProductForSale{

    private boolean sugar;

    public Coke(String type, double price, String description) {
        super(type, price, description);
    }

    public Coke(String type, double price, String description, boolean sugar) {
        super(type, price, description);
        this.sugar = sugar;
    }

    @Override
    public void showDetails() {
        System.out.println("Coke { sugar = " + sugar +
                " price = " +getPrice() +" description = " + getDescription() + " }");
    }

    public boolean isSugar() {
        return sugar;
    }
}

package org.example.model;

public class Chocolate extends ProductForSale {

    private boolean hazelnut;

    public Chocolate(String type, double price, String description) {
        super(type, price, description);
    }

    public Chocolate(String type, double price, String description, boolean hazelnut) {
        super(type, price, description);
        this.hazelnut = hazelnut;
    }

    @Override
    public String toString() {
        return "Chocolate{" +
                "hazelnut=" + hazelnut +
                '}';
    }

    @Override
    public void showDetails() {
        System.out.println("Chocolate { hazelnut = " + hazelnut +
                " price = " +getPrice() +" description = " + getDescription() + " }");

    }

    public boolean isHazelnut() {
        return hazelnut;
    }
}

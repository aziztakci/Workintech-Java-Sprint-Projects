package org.example.model;

public class Bread extends ProductForSale{

    private boolean gluten;

    public Bread(String type, double price, String description) {
        super(type, price, description);
    }

    public Bread(String type, double price, String description, boolean gluten) {
        super(type, price, description);
        this.gluten = gluten;
    }

    @Override
    public void showDetails() {
        System.out.println("Bread { gluten = " + gluten +
                " price = " +getPrice() +" description = " + getDescription() + " }");
    }

    public boolean isGluten() {
        return gluten;
    }
}

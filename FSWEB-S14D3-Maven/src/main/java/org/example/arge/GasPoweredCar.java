package org.example.arge;

public class GasPoweredCar extends CarSkeleton {

    private double avgKmPerLitre;
    private int cylinders;

    public GasPoweredCar(String name, String description, double avgKmPerLitre, int cylinders) {
        super(name,description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    public double getAvgKmPerLitre() {
        return avgKmPerLitre;
    }

    public int getCylinders() {
        return cylinders;
    }

    @Override
    protected void runEngine() {
        System.out.println("Gas powered engine system is managing gas...");
    }

    @Override
    public void startEngine() {
        System.out.println(getName() + " gas engine is starting with " + cylinders + " cylinders.");
    }

    @Override
    public void drive() {
        System.out.println(getName() + " is driving. Fuel consumption: " + avgKmPerLitre + " km/l");
        runEngine();
    }

}

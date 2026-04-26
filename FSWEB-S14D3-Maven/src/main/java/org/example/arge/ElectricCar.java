package org.example.arge;

public class ElectricCar extends CarSkeleton {
    private double avgKmPerCharge;
    private int batterySize;

    public ElectricCar(String name, String description, double avgKmPerCharge, int batterySize) {
        super(name, description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
    }

    public double getAvgKmPerCharge() {
        return avgKmPerCharge;
    }

    public int getBatterySize() {
        return batterySize;
    }

    @Override
    protected void runEngine() {
        System.out.println("Electric car engine system is managing battery ...");
    }

    @Override
    public void startEngine() {
        System.out.println("Electric motor is humming... Battery level: " + batterySize + " kWh.");
    }

    @Override
    public void drive() {
        System.out.println(getName() + " is driving silently.");
        runEngine();
    }
}

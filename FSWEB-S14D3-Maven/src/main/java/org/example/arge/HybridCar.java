package org.example.arge;

public class HybridCar extends CarSkeleton {

    private double avgKmPerLitre;
    private int batterySize;
    private int cylinders;


    public HybridCar(String name, String description, double avgKmPerLitre, int batterySize, int cylinders) {
        super(name, description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.batterySize = batterySize;
        this.cylinders = cylinders;
    }

    public double getAvgKmPerLitre() {
        return avgKmPerLitre;
    }

    public int getBatterySize() {
        return batterySize;
    }

    public int getCylinders() {
        return cylinders;
    }

    @Override
    protected void runEngine() {
        System.out.println("Hybrid engine system is managing energy between battery and gas...");
    }

    @Override
    public void startEngine() {
        System.out.println("Hybrid system is initializing... Dual power ready.");
        System.out.println("Electric motor active (Battery: " + batterySize + "kWh) and " +
                cylinders + " cylinders are primed.");
    }

    @Override
    public void drive() {
        System.out.println(getName() + " is driving in hybrid mode. Optimal efficiency: " +
                avgKmPerLitre + " km/L.");
        runEngine();
    }
}

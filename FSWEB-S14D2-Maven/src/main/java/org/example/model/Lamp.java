package org.example.model;

import org.example.model.enums.LampType;

public class Lamp {
    private LampType style;
    private boolean battery;
    private int globRating;

    public Lamp(  LampType style,boolean battery, int globRating) {
        this.battery = battery;
        this.style = style;
        this.globRating = globRating;
    }

    public void turnOn () {
        System.out.println("Lamp is being turned on");
    }

    public LampType getStyle () {
        return this.style;
    }

    public boolean isBattery () {
        return this.battery;
    }

    public int getGlobRating() {
        return  this.globRating;
    }
}

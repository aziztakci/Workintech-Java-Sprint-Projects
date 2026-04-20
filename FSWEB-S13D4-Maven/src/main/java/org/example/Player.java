package org.example;



public class Player {
    private String name;
    private int healthPercentage;
    private Weapon weapon;

    public Player (String name, int healthPercentage, Weapon weapon) {
        this.name = name;
        this.healthPercentage = healthPercentage;
        checkLife(healthPercentage);
        this.weapon = weapon;
    }

    public void checkLife(int health) {
        if(health < 0) {
            this.healthPercentage = 0;
        }

        if (health>100) {
            this.healthPercentage = 100;
        }
    }

    public int healthRemaining() {
       return this.healthPercentage;
    }

    public void loseHealth (int damage) {
        int healthRemain = this.healthPercentage - damage;
        System.out.println(name + " player has been knocked out of game");
        this.healthPercentage = healthRemain;
        checkLife(healthPercentage);
    }

    public void restoreHealth(int potion) {
        int restoredHealth = this.healthPercentage + potion;
        this.healthPercentage = restoredHealth;
        checkLife(this.healthPercentage);
    }


}

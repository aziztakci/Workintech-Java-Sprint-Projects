package org.example;

    public enum Weapon {
        SWORD(30, 7),
        AXE(45,4),
        BOW(25,5),
        SHIELD(10,1);

        private final int damage;
        private double attackSpeed;

        Weapon(int dmg, double attackSpeed) {
            this.damage = dmg;
            this.attackSpeed = attackSpeed;
        }

        public int getDamage() {
            return this.damage;
        }

        public double getAttackSpeed() {
            return this.attackSpeed;
        }
    }


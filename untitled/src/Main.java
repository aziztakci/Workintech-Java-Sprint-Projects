package org.example;

// Sınıfları main'in dışına, sınıf seviyesine taşıyoruz.
class Building {}
class House extends Building {}

public class Main {
    public static void main(String[] args) {
        System.out.println("Program başlatılıyor...");

        convert();
    }

    public static void convert() {
        Building b = new Building();
        House h = new House();
        Building bh = new House();

        House q = (House) h;
        House r = (House) bh;
    }
}
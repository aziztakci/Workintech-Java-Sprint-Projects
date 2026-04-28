package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {

    public static List<String> groceryList = new ArrayList<>();

    public void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("0: Çıkış, 1: Ekle, 2: Çıkar");
            System.out.print("Seçiminiz: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Lütfen geçerli bir sayı giriniz.");
                scanner.nextLine();
                continue;
            }

            if (choice == 0) {
                System.out.println("Uygulama durduruluyor...");
                break;
            } else if (choice == 1) {
                System.out.println("Eklenmesini istediğiniz elemanları giriniz (Virgül ile ayırabilirsiniz):");
                String input = scanner.nextLine();
                addItems(input);
            } else if (choice == 2) {
                System.out.println("Çıkarılmasını istediğiniz elemanları giriniz (Virgül ile ayırabilirsiniz):");
                String input = scanner.nextLine();
                removeItems(input);
            } else {
                System.out.println("Geçersiz seçenek. 0, 1 veya 2 giriniz.");
            }
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (!checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
            } else {
                System.out.println(trimmedItem + " zaten listede mevcut.");
            }
        }
        printSorted();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (checkItemIsInList(trimmedItem)) {
                groceryList.remove(trimmedItem);
            } else {
                System.out.println(trimmedItem + " listede bulunamadığı için silinemedi.");
            }
        }
        printSorted();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Güncel ve Sıralı Liste: " + groceryList);
    }
}
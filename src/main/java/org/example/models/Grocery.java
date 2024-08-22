package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList=new ArrayList<>();
    public void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Bir seçenek seçiniz:");
            System.out.println("0 - Uygulamayı durdur");
            System.out.println("1 - Eleman ekle");
            System.out.println("2 - Eleman çıkar");

            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    isRunning = false;
                    System.out.println("Uygulama durduruldu.");
                    break;
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz (virgül ile ayırabilirsiniz):");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    break;
                case 2:
                    System.out.println("Çıkarılmasını istediğiniz elemanları giriniz (virgül ile ayırabilirsiniz):");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    break;
                default:
                    System.out.println("Geçersiz seçenek, lütfen tekrar deneyin.");
            }
        }

        scanner.close();
    }

    public static void addItems(String input) {
        String[] itemsArray = input.split(",");
        for (String item : itemsArray) {
            String trimmedItem = item.trim();
            if (!checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
            }
        }
        printSorted();
    }

    public static void removeItems(String input) {
        String[] itemsArray = input.split(",");
        for (String item : itemsArray) {
            String trimmedItem = item.trim();
            groceryList.remove(trimmedItem);
        }
        printSorted();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Güncel ve sıralı liste: " + groceryList);
    }
}


package org.example;

public class Main {

    public static boolean checkForPalindrome(String text) {
        // Regex'i daha kapsayıcı hale getirdik ve boşlukları kesin temizliyoruz
        String cleaned = text.replaceAll("[\\W_]", "").toLowerCase();

        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String convertDecimalToBinary(int decimal) {
        if (decimal == 0) return "0";

        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary.insert(0, remainder);
            decimal = decimal / 2;
        }
        return binary.toString();
    }
}
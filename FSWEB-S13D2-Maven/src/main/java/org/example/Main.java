package org.example;

public class Main {
    public static void main(String[] args) {

    }

    public static boolean isPalindrome(int number) {
        String str = String.valueOf(Math.abs(number));
        int n = str.length();

        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPerfectNumber(int number) {
        if (number < 0) {
            return false;
        }

        int total = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                total += i;
            }
        }

        return total == number;
    }

    public static String numberToWords(int number) {
        if (number < 0) {
            return "Invalid Value";
        }

        String numberStr = String.valueOf(number);
        String result = "";

        for (int i = 0; i < numberStr.length(); i++) {
            char digit = numberStr.charAt(i);
            switch (digit) {
                case '0': result += "Zero "; break;
                case '1': result += "One "; break;
                case '2': result += "Two "; break;
                case '3': result += "Three "; break;
                case '4': result += "Four "; break;
                case '5': result += "Five "; break;
                case '6': result += "Six "; break;
                case '7': result += "Seven "; break;
                case '8': result += "Eight "; break;
                case '9': result += "Nine "; break;
            }
        }

        return result.trim();
    }
}
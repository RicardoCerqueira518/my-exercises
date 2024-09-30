package io.codeforall.bootcamp;

public class Ai {

    private String creationDate;
    private String name;

    public Ai (String creationDate, String name){
        this.creationDate = creationDate;
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int[] doubleArray(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i] * 2;
        }
        return newArray;
    }

    public static int factorialIterative(int number) {
        int factorial = number;
        for (int i = (number - 1); i > 1; i--) {
            factorial = factorial * i;
        }
        return factorial;
    }

    public static long factorialRecursive(int number) {
        if (number < 0) {
            return -1;
        }
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * factorialRecursive(number - 1);
    }

    public String palindromeReplace(String input) {
        String[] words = input.split("\\s+");
        String result = "";

        for (String word : words) {

            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            if (isPalindrome(cleanWord) && cleanWord.length() > 1) {
                result += "palindrome ";
            } else {
                result += word + " ";
            }
        }

        if (result.length() > 0) {
            result = result.substring(0, result.length() - 1);
        }

        return result;
    }


    private boolean isPalindrome(String word) {
        word = word.toLowerCase();
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String emailValidator() {
        return "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    }

}

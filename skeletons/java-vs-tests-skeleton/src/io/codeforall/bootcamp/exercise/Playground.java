package io.codeforall.bootcamp;

public class Playground {

    public static void main(String[] args) {

        Ai ai = new Ai("1991-11-09", "Ricardo");
        System.out.println("Creation Date: " + ai.getCreationDate());
        System.out.println("Name: " + ai.getName());

        int[] n = {5,10,15};
        int[] ns = ai.doubleArray(n);
        System.out.print("Doubled Array: ");
        for (int num : ns) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println(Ai.factorialIterative(5));
        System.out.println(Ai.factorialRecursive(4));


        String sentence = "ana ou hannah, não consigo reter";
        String modifiedExpression = ai.palindromeReplace(sentence);
        System.out.println("Modified expression: " + modifiedExpression);


        String emailRegex = ai.emailValidator();
        System.out.println("Email validation regex: " + emailRegex);

        String testEmail = "ricardo_cerqueira1@hotmail.com";
        boolean isValid = testEmail.matches(emailRegex);
        System.out.println("Email: " + testEmail + " is " + (isValid ? "Valid" : "Invalid"));
    }


}


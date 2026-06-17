package util;

public class InputValidator {

    public static boolean isValidAmount(double amount) {

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return false;
        }

        return true;
    }
}
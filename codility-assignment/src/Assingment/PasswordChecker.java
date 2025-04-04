package Assingment;

import java.util.Scanner;

public class PasswordChecker {
    
    
    public static String checkPassword(String password) {
        boolean hasLowercase = false;
        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecialCharacters = false;

        if (password.length() < 8) {
            return "Weak: Password must be at least 8 characters long.";
        }

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            
            if (Character.isLowerCase(c)) 
            {
                hasLowercase = true;
            } else if (Character.isUpperCase(c)) 
            {
                hasUppercase = true;
            } else if (Character.isDigit(c)) 
            {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) 
            {
                hasSpecialCharacters = true;
            }
        }

        if (hasLowercase && hasUppercase && hasDigit && hasSpecialCharacters) {
            return "Strong Password";
        } else if ((hasLowercase && hasUppercase && hasDigit) || 
                   (hasLowercase && hasUppercase && hasSpecialCharacters)) {
            return "Moderate Password.";
        } else {
            return "Weak Password";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a password to check strength:");
        String password = scanner.nextLine();

        String result = checkPassword(password);
        System.out.println(result);

    }
}

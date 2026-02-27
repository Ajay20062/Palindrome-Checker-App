import java.util.*;

/**
 * =====================================================
 * MAIN CLASS - Palindrome Checker App
 * =====================================================
 * <p>
 * All palindrome validation techniques combined.
 * Now accepts input from user.
 *</p>
 * @author T R Ajay Dharrsan
 * @version 1.0
 */

public class PalindromeCheckerApp {

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=======================================================");
        System.out.println("               PALINDROME CHECKER App         ");
        System.out.println("=======================================================");
        System.out.println();
        System.out.println("=======================================================");
        System.out.println("                 Version: 1.0                 ");
        System.out.println("     Welcome to Palindrome Application!       ");
        System.out.println("       Application started successfully.      ");
        System.out.println("========================================================");
        System.out.println();
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("========================================================");

        System.out.println("UC2 - Half Loop            : " + checkHalfLoop(input));
    }

    // UC2 - Half Loop
    public static boolean checkHalfLoop(String input) {
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
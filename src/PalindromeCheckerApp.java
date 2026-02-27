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
 * @version 3.0
 */

public class PalindromeCheckerApp {

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=======================================================");
        System.out.println("               PALINDROME CHECKER App         ");
        System.out.println("=======================================================");
        System.out.println();
        System.out.println("=======================================================");
        System.out.println("                 Version: 3.0                 ");
        System.out.println("     Welcome to Palindrome Application!       ");
        System.out.println("       Application started successfully.      ");
        System.out.println("========================================================");
        System.out.println();
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("========================================================");

        System.out.println("UC2 - Half Loop                 : " + checkHalfLoop(input));
        System.out.println("UC3 - Reverse String            : " + checkReverse(input));
        scanner.close();
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
    // UC3 - Reverse String
    public static boolean checkReverse(String input) {
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return input.contentEquals(reversed);
    }
}

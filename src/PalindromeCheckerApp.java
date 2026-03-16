
import java.util.*;
/**
 * =====================================================
 * MAIN CLASS - Palindrome Checker App
 * =====================================================
 * All palindrome validation techniques combined.
 * Now accepts input from user.
 *
 * @author T R Ajay Dharrsan
 * @version 13.0
 */

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("================================================================");
        System.out.println("                    PALINDROME CHECKER APP                      ");
        System.out.println("================================================================");
        System.out.println("                Version: 13.0                                   ");
        System.out.println("         Application Started Successfully!                      ");
        System.out.println();
        System.out.println("================================================================");

        System.out.print("\nEnter a string : ");
        String input = scanner.nextLine();

        System.out.println("\n==============================================================");

        System.out.printf("%-35s %-10s %-20s\n", "Method", "Result", "Execution Time");
        System.out.println("----------------------------------------------------------------");

        runAndMeasure("UC2  - Half Loop", () -> checkHalfLoop(input));
        runAndMeasure("UC3  - Reverse String", () -> checkReverse(input));
        runAndMeasure("UC4  - Two Pointer", () -> checkTwoPointer(input));
        runAndMeasure("UC5  - Stack", () -> checkStack(input));
        runAndMeasure("UC6  - Queue + Stack", () -> checkQueueStack(input));
        runAndMeasure("UC7  - Deque", () -> checkDeque(input));
        runAndMeasure("UC8  - Linked List", () -> checkLinkedList(input));
        runAndMeasure("UC9  - Recursive", () -> checkRecursivePalindrome(input));
        runAndMeasure("UC10 - Ignore Case & Space", () -> checkIgnoreCaseSpace(input));

        PalindromeService service = new PalindromeService();
        runAndMeasure("UC11 - OOP Service", () -> service.checkPalindrome(input));

        PalindromeService.StackStrategy stackStrategy = new PalindromeService.StackStrategy();
        PalindromeService.DequeStrategy dequeStrategy = new PalindromeService.DequeStrategy();

        runAndMeasure("UC12 - Strategy (Stack)", () -> stackStrategy.checkPalindrome(input));
        runAndMeasure("UC12 - Strategy (Deque)", () -> dequeStrategy.checkPalindrome(input));

        scanner.close();
    }

    /**
     * UC13 - Performance Measurement
     */
    public static void runAndMeasure(String methodName, PalindromeCheck check) {

        long start = System.nanoTime();
        boolean result = check.run();
        long end = System.nanoTime();

        long time = end - start;

        System.out.printf("%-35s %-10s %-20d ns\n", methodName, result, time);
    }

    /**
     * Functional Interface
     */
    public static interface PalindromeCheck {
        boolean run();
    }

    // =====================================================
    // UC2 - Half Loop
    // =====================================================

    public static boolean checkHalfLoop(String input) {

        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // =====================================================
    // UC3 - Reverse String
    // =====================================================

    public static boolean checkReverse(String input) {

        StringBuilder reversed = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }

        return input.contentEquals(reversed);
    }

    // =====================================================
    // UC4 - Two Pointer
    // =====================================================

    public static boolean checkTwoPointer(String input) {

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {

            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    // =====================================================
    // UC5 - Stack
    // =====================================================

    public static boolean checkStack(String input) {

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {

            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // =====================================================
    // UC6 - Queue + Stack
    // =====================================================

    public static boolean checkQueueStack(String input) {

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }

        while (!queue.isEmpty()) {

            if (queue.remove() != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // =====================================================
    // UC7 - Deque
    // =====================================================

    public static boolean checkDeque(String input) {

        Deque<Character> deque = new LinkedList<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {

            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }

    // =====================================================
    // UC8 - Linked List
    // =====================================================

    public static boolean checkLinkedList(String input) {

        LinkedList<Character> list = new LinkedList<>();

        for (char c : input.toCharArray()) {
            list.add(c);
        }

        while (list.size() > 1) {

            if (!list.removeFirst().equals(list.removeLast())) {
                return false;
            }
        }

        return true;
    }

    // =====================================================
    // UC9 - Recursive
    // =====================================================

    public static boolean checkRecursivePalindrome(String input) {
        return recursive(input, 0, input.length() - 1);
    }

    private static boolean recursive(String input, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (input.charAt(start) != input.charAt(end)) {
            return false;
        }

        return recursive(input, start + 1, end - 1);
    }

    // =====================================================
    // UC10 - Ignore Case & Space
    // =====================================================

    public static boolean checkIgnoreCaseSpace(String input) {

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        for (int i = 0; i < normalized.length() / 2; i++) {

            if (normalized.charAt(i) != normalized.charAt(normalized.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}

/**
 * =====================================================
 * UC11 - SERVICE CLASS (OOP)
 * =====================================================
 */

class PalindromeService {

    public boolean checkPalindrome(String input) {

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {

            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Strategy Pattern Interface
     */
    interface PalindromeStrategy {
        boolean checkPalindrome(String input);
    }

    /**
     * Stack Strategy
     */
    static class StackStrategy implements PalindromeStrategy {

        public boolean checkPalindrome(String input) {

            Stack<Character> stack = new Stack<>();

            for (char c : input.toCharArray()) {
                stack.push(c);
            }

            for (char c : input.toCharArray()) {

                if (c != stack.pop()) {
                    return false;
                }
            }

            return true;
        }
    }

    /**
     * Deque Strategy
     */
    static class DequeStrategy implements PalindromeStrategy {

        public boolean checkPalindrome(String input) {

            Deque<Character> deque = new LinkedList<>();

            for (char c : input.toCharArray()) {
                deque.addLast(c);
            }

            while (deque.size() > 1) {

                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }

            return true;
        }
    }
}

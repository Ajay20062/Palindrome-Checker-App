import java.util.*;

/**
 * =====================================================
 * MAIN CLASS - Palindrome Checker App
 * =====================================================
 * All palindrome validation techniques combined.
 * Now accepts input from user.
 * UC10 added: Case-insensitive and space-ignored palindrome
 *
 * @author T R Ajay Dharrsan
 * @version 12.0
 */

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=======================================================");
        System.out.println("                PALINDROME CHECKER APP                 ");
        System.out.println("=======================================================");
        System.out.println("Version: 12.0");
        System.out.println("Application Started Successfully!");
        System.out.println();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("=======================================================");

        System.out.println("UC2 - Half Loop                    : " + checkHalfLoop(input));
        System.out.println("UC3 - Reverse String               : " + checkReverse(input));
        System.out.println("UC4 - Two Pointer                  : " + checkTwoPointer(input));
        System.out.println("UC5 - Stack                        : " + checkStack(input));
        System.out.println("UC6 - Queue + Stack                : " + checkQueueStack(input));
        System.out.println("UC7 - Deque                        : " + checkDeque(input));
        System.out.println("UC8 - Linked List Based            : " + checkLinkedList(input));
        System.out.println("UC9 - Recursive Palindrome         : " + checkRecursivePalindrome(input));
        System.out.println("UC10 - Ignore Case & Space         : " + checkIgnoreCaseSpace(input));

        PalindromeService service = new PalindromeService();
        System.out.println("UC11 - OOP Palindrome Service      : " + service.checkPalindrome(input));

        // UC12 Strategy Pattern
        PalindromeService.StackStrategy stackStrategy = new PalindromeService.StackStrategy();
        PalindromeService.DequeStrategy dequeStrategy = new PalindromeService.DequeStrategy();

        System.out.println("UC12 - Strategy Pattern (Stack)    : " + stackStrategy.checkPalindrome(input));
        System.out.println("UC12 - Strategy Pattern (Deque)    : " + dequeStrategy.checkPalindrome(input));

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

        return input.equals(reversed.toString());
    }

    // UC4 - Two Pointer
    public static boolean checkTwoPointer(String input) {

        char[] chars = input.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        while (start < end) {

            if (chars[start] != chars[end]) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    // UC5 - Stack
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

    // UC6 - Queue + Stack
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

    // UC7 - Deque
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

    // UC8 - Linked List
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

    // UC9 - Recursive
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

    // UC10 - Ignore Case and Spaces
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
 * UC11 - Object Oriented Palindrome Service
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
     * =====================================================
     * UC12 - Strategy Pattern Interface
     * =====================================================
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

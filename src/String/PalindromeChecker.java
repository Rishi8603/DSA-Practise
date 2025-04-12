package String;

public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        // Remove any non-alphanumeric characters and convert the string to lowercase
        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Initialize pointers to start and end of the string
        int start = 0;
        int end = cleanedStr.length() - 1;

        // Check if the characters at the start and end are the same
        while (start < end) {
            if (cleanedStr.charAt(start) != cleanedStr.charAt(end)) {
                return false; // Not a palindrome
            }
            start++;
            end--;
        }

        return true; // It's a palindrome
    }

    public static void main(String[] args) {
        String input = "A man, a plan, a canal, Panama!";

        if (isPalindrome(input)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }
    }
}


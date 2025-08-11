package Recursion;

public class pracccctise {
    public static void main(String[] args) {
        String input = "./Naan";
        System.out.println(isPalindrome(input));
    }

    public static boolean isPalindrome(String input) {
        String Lowercase=input.toLowerCase();
        String result="";
        for (char c : Lowercase.toCharArray()) {
            if (Character.isLetter(c)) {
               result += c;
            }
        }
        System.out.println(result);
        return isPalindrome(result, 0, result.length() - 1);
    }

    public static boolean isPalindrome(String result, int start, int end) {

        // Base case: if start >= end, it's a palindrome
        if (start >= end) {
            return true;
        }
        // If characters at start and end don't match, it's not a palindrome
        if (result.charAt(start) != result.charAt(end)) {
            return false;
        }

        // Recursive case: check the remaining substring
        return isPalindrome(result, start + 1, end - 1);
    }
}
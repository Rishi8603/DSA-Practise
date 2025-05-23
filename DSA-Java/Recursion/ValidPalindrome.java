package Recursion;

public class ValidPalindrome {
    public static void main(String[] args) {
        String input = "1.am. anaplanacanalpanama";
        System.out.println(isPalindrome(input));
    }
    public static boolean isPalindrome(String s) {
        String Lowercase=s.toLowerCase();
        String result="";
        for (char c : Lowercase.toCharArray()) {
            if (Character.isLetter(c)||Character.isDigit(c)) {
                result += c;
            }
        }
        System.out.println(result);
        return isPalindrome(result, 0, result.length() - 1);
    }

    private static boolean isPalindrome(String result, int start, int end) {

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

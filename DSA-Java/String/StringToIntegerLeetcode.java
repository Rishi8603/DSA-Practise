package String;

public class StringToIntegerLeetcode {
    public static void main(String[] args) {
        String s = "9223372036854775808";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        // Step 1: Trim leading spaces
        s = s.trim();
        if (s.isEmpty()) return 0;

        // Step 2: Handle optional '+' or '-' sign
        int index = 0, sign = 1;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            if (s.charAt(index) == '-') {
                sign = -1;
            } else {
                sign = 1;
            }
            index++;
        }

        // Step 3: Convert the digits to an integer
        long result = 0; // Use long to detect overflow
        while (index < s.length()) {
            char currentChar = s.charAt(index);
            // Stop if the current character is not a digit
            if (!Character.isDigit(currentChar)) {
                break;
            }
            // Convert the character to a digit and add to the result
            int digit = currentChar - '0';
            result = result * 10 + digit;
            // Check for overflow
            if (result * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }if (result * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            index++; // Move to the next character
        }
        // Step 4: Return the final result with the sign
        return (int) (result * sign);
    }
}

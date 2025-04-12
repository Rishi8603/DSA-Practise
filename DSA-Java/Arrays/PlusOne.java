package Arrays;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits={9,8,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0; // Carry propagates
        }
        // If we reach here, all digits were 9 (e.g., 999 → 1000)
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}

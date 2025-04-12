package BitManipulation;

public class ReverseBits {
    public static void main(String[] args) {
        String binaryString = "11111111111111111111111111111101";
        int n = Integer.parseUnsignedInt(binaryString, 2);
        System.out.println(Integer.toUnsignedString(reverse(n)));

    }
    public static int reverse(int n){
        // Convert to 32-bit binary string with padding
        String binaryString = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');

        // Reverse the binary string
        String reversed = "";
        for (int i = binaryString.length() - 1; i >= 0; i--) {
            reversed += binaryString.charAt(i);
        }

        // Convert the reversed binary string to an unsigned integer
        long ans = converter(reversed);

        // Cast back to int to return a 32-bit result
        return (int) ans;
    }
    public static long converter(String binaryString) {
        long decimal = 0;
        int length = binaryString.length();

        // Iterate over the binary string from right to left
        for (int i = 0; i < length; i++) {
            // Get the current character from the right (0 or 1)
            char bit = binaryString.charAt(length - i - 1);

            // Convert the character to integer and multiply by 2^i if it's '1'
            if (bit == '1') {
                decimal += Math.pow(2, i);
            }
        }
        return decimal;
    }
}

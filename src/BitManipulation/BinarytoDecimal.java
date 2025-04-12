package BitManipulation;

public class BinarytoDecimal {
    public static void main(String[] args) {
        String binaryString = "10110011";  // Binary representation as a string
        System.out.println(converter(binaryString));
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

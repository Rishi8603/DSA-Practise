package Maths;

public class palindromeCheck {
    public static void main(String[] args) {
        int n=0;
        System.out.println(isPalindrome(n));
    }
    public static boolean isPalindrome(int x){
        int reversed=0;
        int temp= x;
        int i=0;
        while(x !=0){
            int rem= x %10;
            x = x /10;
            // Check for overflow before updating reversed
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && rem > 7)) {
                return false; // Overflow
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && rem < -8)) {
                return false; // Underflow
            }
            reversed=reversed*10+rem;
            i++;
        }
        if(reversed==temp&&temp>=0) return true;
        else return false;
    }
}

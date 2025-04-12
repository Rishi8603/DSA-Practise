package Recursion;

public class DigitCount {
    public static void main(String[] args) {
        int n=1010;
        System.out.println(countDigit(n));
    }
    public static int countDigit(int val){
        if(val==0){
            return 0;
        }
        return 1+countDigit(val/10);
    }
}

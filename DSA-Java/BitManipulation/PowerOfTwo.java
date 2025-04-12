package BitManipulation;

public class PowerOfTwo {
    public static void main(String[] args) {
        int n=6;
        System.out.println(isPowerOfTwo(n));
    }
    public static boolean isPowerOfTwo(int n){
        return (n & (n-1)) == 0 && n > 0;
    }
}

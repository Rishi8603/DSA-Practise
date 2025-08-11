package Maths;

public class ModularExponentiation {
    public static void main(String[] args) {
        long x=2;
        long y=3;
        long mod=1000000007;
        System.out.println(modPower(x,y,mod));
    }
    static long modPower(long x, long y, long mod) {
        if (y == 0) return 1;  // Base case: x^0 = 1

        long half = modPower(x, y / 2, mod);

        if (y % 2 == 0)
            return (half * half) % mod;  // Directly return for even y
        else
            return (x * (half * half % mod)) % mod;  // Multiply x if y is odd
    }
    private static long modInverse(long a, int mod) {
        return modPower(a, mod - 2, mod);
    }
}

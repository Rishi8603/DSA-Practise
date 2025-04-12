package Maths;

public class Power {
    public static void main(String[] args) {
        double x = 20;
        int n = 25;
        System.out.println(3/2);
        System.out.println(myPow(x,n));
    }
    public static double myPow(double x, int n) {
        long absN = Math.abs((long) n); // Avoid integer overflow
        double ans = 1;
        while (absN > 0) {
            if ((absN & 1) == 1) {
                ans *= x;
            }
            x *= x;
            absN >>= 1;
        }
        if (n < 0) {
            return 1 / ans;
        } else {
            return ans;
        }
    }
//    public static long striver(long x,long n){
//        long ans=1;
//        while(n>0){
//            if(n%2==1){
//                ans=ans*x;
//                n=n-1;
//            }else{
//                x=x*x;
//                n=n/2;
//            }
//        }
//        return ans;
//    }
}

package Recursion;

public class PowerUsingRecursion {
    public static void main(String[] args) {
        double x=2;
        int n=-2;
        System.out.println(myPow(x,n));
    }
    public static double myPow(double x,int n){
        int ans=1;
        long absN = Math.abs((long) n); // Avoid integer overflow
        return myPow(ans,x,n,absN);
    }
    public static double  myPow(double ans,double x, int n,long absN){
        //base case
        if(absN==0){
            if (n < 0) {
                return 1 / ans;
            } else {
                return ans;
            }
        }
        if((absN&1)==1){
            ans=ans*x;
        }
        x=x*x;
        absN=absN>>1;
        return myPow(ans,x,n,absN);
    }
}

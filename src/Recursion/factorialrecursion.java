package Recursion;

public class factorialrecursion {
    public static void main(String[] args) {
        int n=1342;
        int ans=fun(n);
        System.out.println(ans);
    }
    public static int fun(int n){
        if(n/10==n){
            return n;
        }
        return n%10 + fun(n/10);
    }
}

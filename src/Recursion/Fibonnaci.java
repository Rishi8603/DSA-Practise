package Recursion;

public class Fibonnaci {
    public static void main(String[] args) {
        int num=4;
        System.out.println(fib(num));
    }
    public static int fib(int n){
       if(n==0 ){
           return 0;
       }
        if(n==1 ){
            return 1;
        }
       return fib(n-1)+fib(n-2);
    }
}

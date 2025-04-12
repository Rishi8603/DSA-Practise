package Maths;

import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("enter number dear:");
        int n=in.nextInt();
        factorial(n);
        int factorial = factorial(n);
        System.out.println(factorial);
    }
    static int factorial(int n){
        int Pn=1;
        for(int i=1;i<=n;i++) {
            int Pnm1 = factorial(i - 1);
            Pn = Pnm1 * i;
        }
        return Pn;
    }
}

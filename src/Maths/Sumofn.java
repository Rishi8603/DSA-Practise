package Maths;

import java.util.Scanner;

public class Sumofn {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter number:");
        int n = in.nextInt();
        sum(n);
    }

    static int sum(int n){
        int Sumnm1=sum(n-1);
        int Sumn=Sumnm1+n;
        return Sumn;
    }
}

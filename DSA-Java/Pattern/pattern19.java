package Pattern;

import java.util.Scanner;

public class pattern19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter N:");
        int N = in.nextInt();
        pattern(N);
    }

    static void pattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int s = 0; s < n - i; s++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2 * i; j++) {
                System.out.print(" ");
            }
            for (int ss = 0; ss < n - i; ss++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int s = 0; s<=i; s++) {
                System.out.print("*");
            }
            for (int j = 0 ; j<2*(n-i)-2 ;j++) {
                System.out.print(" ");
            }
            for (int ss = 0; ss<=i; ss++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
}

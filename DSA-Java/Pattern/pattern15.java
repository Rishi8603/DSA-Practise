package Pattern;

import java.util.Scanner;

public class pattern15 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter N:");
        int N=in.nextInt();
        pattern(N);
    }
    static void pattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (char j = 'A'; j < 'A'+(n-i+1); j++) {
                System.out.print((char)(j));
            }
            System.out.println();
        }
    }
}

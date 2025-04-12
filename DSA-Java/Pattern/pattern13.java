package Pattern;

import java.util.Scanner;

public class pattern13 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter N:");
        int N=in.nextInt();
        pattern(N);
    }
    static void pattern(int n) {
        int start=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(start + "   ");
                start=start+1;
            }
            System.out.println();
        }
    }
}

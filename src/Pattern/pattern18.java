package Pattern;

import java.util.Scanner;

public class pattern18 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter N:");
        int N=in.nextInt();
        pattern(N);
    }
    static void pattern(int n) {
        for (int i = 1; i <=n; i++) {
            for (char j = 'E'; j < 'E'+ i; j--) {
                System.out.print((char)j);
            }
            System.out.println();
        }
    }
}

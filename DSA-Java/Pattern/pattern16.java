package Pattern;

import java.util.Scanner;

public class pattern16 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter N:");
        int N=in.nextInt();
        pattern(N);
    }
    static void pattern(int n) {
        for (char i = 'A'; i <'A'+n; i++) {
            for (char j = 'A'; j <= i; j++) {
                System.out.print((char)(i));
            }
            System.out.println();
        }
    }
}

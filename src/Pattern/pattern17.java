package Pattern;

import java.util.Scanner;

public class pattern17 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter N:");
        int N=in.nextInt();
        pattern(N);
    }
    static void pattern(int n) {
        for (int i = 0; i < n; i++) {
            for (char j = 'A'; j <='A'+(n-i-1); j++) {
                System.out.print(" ");
            }
            char ch='A';
            for (int j = 1; j <= 2*i+1; j++) {
                if(j<=i){
                    System.out.print(ch);
                    ch++;
                }else{
                    System.out.print(ch);
                    ch--;
                }
            }
            for (char j = 'A'; j <= 'A'+(n-i-1); j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

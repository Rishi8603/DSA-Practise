package Pattern;

import java.util.Scanner;

public class pattern10m2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter N:");
        int N=in.nextInt();
        pattern10(N);
    }
    static void pattern10(int N){
        for (int i = 1; i <=2*N-1; i++) {
            int stars=i;
            if(i>N){
                stars=2*N-i;
            }
            for (int j = 1; j <=stars ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

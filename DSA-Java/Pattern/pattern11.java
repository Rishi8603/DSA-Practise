package Pattern;

import java.util.Scanner;

public class pattern11 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter N:");
        int N=in.nextInt();
        pattern(N);
    }
    static void pattern(int n){
        int start=1;
        for (int i = 0; i < n; i++) {
            if(i%2==0){
                start=1;
            }else{
                start=0;
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(start);
                start=1-start;
            }
            System.out.println();
        }
    }
}

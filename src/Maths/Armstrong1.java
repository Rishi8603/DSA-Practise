package Maths;

import java.util.Scanner;

public class Armstrong1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("enter number:");
        int num = in.nextInt();
        int count=0;
        while(num>0){
            num=num/10;
            count++;
        }
        System.out.println(count);

    }
}
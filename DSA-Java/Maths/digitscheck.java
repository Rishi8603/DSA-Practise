package Maths;

import java.util.Scanner;

public class digitscheck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("koi  bhi number dallo ji:");
        int num = in.nextInt();
        int count=0;
        while(num!=0){
            num=num/10;
            count++;
        }
        if(count%2==0){
            System.out.println("tmhara number even hei ji");
        }
        else{
            System.out.println("odd hei");
        }
    }
}

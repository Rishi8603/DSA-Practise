package Maths;

import java.util.Scanner;

public class table {
    public static void main(String[] args) {
        System.out.println("enter the number for which you want to see Maths.table of:");
        Scanner in= new Scanner(System.in);
        int num=in.nextInt();
        pahara(num);
    }
public static void pahara(int num){
        for(int i =1;i<=10;i++){
            int res=num*i;
            System.out.println(res);
        }
        return;
    }
}

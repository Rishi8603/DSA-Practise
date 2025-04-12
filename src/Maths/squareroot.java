package Maths;

import java.util.Scanner;

public class squareroot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of which you want to find square root of:");
        int num= in.nextInt();
        /*now we have taken input from the users ...now we need to iterate the number
        we will use brute force method to calculate square root
        so we wil use while loop for this..and we will first divide the number by two
        as no root is greater than the half of the number ...so this will save some time
         */
        //if the number is zero or Main than the number is itself the sq root so return the num itself
        if(num ==0||num==1){
            System.out.println("sq root is the number itself dear");
        }
        int num1=num/2;

        int i=2;
        while(i<num1){
            if(i*i==num){
                System.out.println(i);
            }
            i++;
        }
    }

}

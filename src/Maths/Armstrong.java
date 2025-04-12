package Maths;

import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter num1:");
        int num1 = input.nextInt();
        Scanner in = new Scanner(System.in);
        System.out.println("enter num2:");
        int num2 = in.nextInt();
        arm(num1,num2);
    }

    public static void arm(int num1,int num2)
    {
        for(int num=num1;num<=num2;num++){
           int temp = num;
            int sum = 0;
            while(temp > 0){
                int rem =0;
                rem=temp%10;
                sum = sum+rem*rem*rem;
                temp=temp/10;
                }
            if(sum==num){
                System.out.println(num+" is armstrong");
            }


        }
        return;
    }

    public static class ofzeroes {
        public static void main(String[] args) {
            int n=10002;
            int count=0;
            int ans=fun(n,count);
            System.out.println(ans);
        }

        static int fun(int n,int count){
            if(n==0){
                return count;
            }
            if(n%10==0){
                count++;
            }
            return fun(n/10,count);
        }
    }
}

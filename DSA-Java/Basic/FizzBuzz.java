package Basic;

import java.util.ArrayList;

public class FizzBuzz {
    public static void main(String[] args) {
        helper(30);
    }
    public static void helper(int n){
        //i need to print number from 1 to n...and if nu. is divisible by 3 i'll print fizz..if div. by 5 i'll print buzz..
        //if div. by both than print fizzbuzz
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("fizzbuzz");
            } else if (i % 3 == 0) {
                System.out.println("fizz");
            } else if (i % 5 == 0) {
                System.out.println("buzz");
            } else {
                System.out.println(i);
            }


        }
    }
}

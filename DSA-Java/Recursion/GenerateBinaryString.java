package Recursion;

import java.util.Collections;

public class GenerateBinaryString {
    //we need to generate all binary number without consecutive 1's
    public static void main(String[] args) {
        int n=3;
        String s="";
        fun(n,s);
    }
    public static void fun(int n,String s){
        int m=s.length();
        if (m == n) {
            System.out.println(s);
            return; // Ensure the function stops after printing
        }
        if(m==0 || s.charAt(m-1)=='0'){
            fun(n,s+1);
            fun(n,s+0);
        }
        else fun(n,s+0);
        return;
    }
}

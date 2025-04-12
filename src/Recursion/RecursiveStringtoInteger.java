package Recursion;

public class RecursiveStringtoInteger {
    public static void main(String[] args) {
        String s = "9223372036854775808";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s){
        //spaces
        s=s.trim();
        if(s.isEmpty()) return 0;

        int index = 0, sign = 1;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            if (s.charAt(index) == '-') {
                sign = -1;
            } else {
                sign = 1;
            }
            index++;
        }
        return myAtoi(sign,0,index,s);
    }
    public static int myAtoi(int sign,long result,int index, String s){
        //base case
        if(index==s.length()){
            return (int) result*sign;
        }
        char currentChar=s.charAt(index);
        //condition to check digit
        if(!Character.isDigit(currentChar)){
            return (int) result*sign;
        }
        int digit = currentChar - '0';
        long newResult = result*10+digit;
        // Check for overflow
        if (newResult * sign > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (newResult * sign < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return myAtoi(sign,newResult,index+1,s);
    }
}
package Maths;

public class Leetcode29Divide {
    public static void main(String[] args) {
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(-214748364/-1);
        System.out.println(divide(-2147483648,1));
    }
    public static int divide(int dividend, int divisor) {
        int ans=dividend/divisor;
        if(ans>=Integer.MAX_VALUE ) return Integer.MAX_VALUE;
        if(ans<=Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return ans;
    }
}

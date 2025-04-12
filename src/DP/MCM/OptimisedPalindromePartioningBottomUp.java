package DP.MCM;

import java.util.Arrays;
import java.util.Stack;

public class OptimisedPalindromePartioningBottomUp {
    public static void main(String[] args) {
        String s="nitip";
        System.out.println(minCut(s)+1);
//        Stack<Character> st=new
    }
    static int[][] t;

    //see notion notes for example
    public static int minCut(String s) {
        int n = s.length();
        t = new int[n][n]; // Correct table size
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        return solve(s, 0, n - 1);
    }

    static int solve(String s, int i, int j) {
        if (i >= j || isPalindrome(s, i, j)) { // Check memoization early
            return 0;
        }

        if (t[i][j] != -1) {
            return t[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            if (isPalindrome(s, i, k))
            {
                int tempans=1+solve(s,k+1,j);
                ans = Math.min(ans, tempans);
            }

        }
        return t[i][j] = ans;
    }

    static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

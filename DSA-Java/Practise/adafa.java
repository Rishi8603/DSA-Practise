package Practise;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class adafa {
    public void main(String[] args) {
        String x="abaaa";
        String y="baabaca" ;
        System.out.println(all_longest_common_subsequences(x,y));
    }
    // Build the DP table where dp[i][j] stores the length of the LCS of s1[0...i-1] and s2[0...j-1].
    private void tabulation(String s1, String s2, int[][] dp) {
        int n1 = s1.length();
        int n2 = s2.length();
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }

    // Recursively backtracks through the DP table to find all LCS strings.
    // 'temp' holds the current accumulated LCS (in reverse order) and 'mpp' is a memoization map to avoid duplicate processing.
    private void backtrackDP(String s1, String s2, int i, int j, int[][] dp, Set<String> ans, String temp, Map<String, Boolean> mpp) {
        if (i == 0 || j == 0) {
            // Reverse the temporary string to get the LCS in the correct order.
            String reversed = new StringBuilder(temp).reverse().toString();
            ans.add(reversed);
            return;
        }

        // Create a unique key corresponding to the current state.
        String key = i + "," + j + "," + temp;
        if (mpp.containsKey(key)) return; // Already processed this state.
        mpp.put(key, true);

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            // When characters match, include that character and move diagonally.
            backtrackDP(s1, s2, i - 1, j - 1, dp, ans, temp + s1.charAt(i - 1), mpp);
        } else {
            // If they don't match, try both possibilities if they lead to the same DP value.
            if (dp[i][j] == dp[i - 1][j]) {
                backtrackDP(s1, s2, i - 1, j, dp, ans, temp, mpp);
            }
            if (dp[i][j] == dp[i][j - 1]) {
                backtrackDP(s1, s2, i, j - 1, dp, ans, temp, mpp);
            }
        }
    }

    // Returns a list of all longest common subsequences for strings s and t.
    public List<String> all_longest_common_subsequences(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        // Create a DP table with dimensions (n1+1) x (n2+1) and initialize with zeros.
        int[][] dp = new int[n1 + 1][n2 + 1];
        tabulation(s, t, dp);

        // Use a TreeSet to maintain the answers in sorted order.
        Set<String> ansSet = new TreeSet<>();
        Map<String, Boolean> mpp = new HashMap<>();

        // Perform backtracking starting from the bottom-right of the DP table.
        backtrackDP(s, t, n1, n2, dp, ansSet, "", mpp);

        // Convert the set to a list and return.
        return new ArrayList<>(ansSet);
    }
}



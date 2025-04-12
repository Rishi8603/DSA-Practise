package DP.MCM;
import java.util.*;
public class ScrambledString {
    public static void main(String[] args) {

    }
    static HashMap<String, Boolean> map;

    public boolean isScramble(String s1, String s2) {
        map = new HashMap<>();
        return solve(s1, s2);
    }

    public boolean solve(String a, String b) {
        // Base condition
        if (a.equals(b)) return true;
        if (a.length() != b.length()) return false;  // Ensuring equal length
        if (a.length() <= 1) return false;

        // Memoization
        String key = a + " " + b;
        if (map.containsKey(key)) return map.get(key);

        int n = a.length();
        boolean flag = false;

        for (int i = 1; i < n; i++) {
            // Swapped case (Scrambled)
            boolean case1 = solve(a.substring(0, i), b.substring(n - i, n)) &&
                    solve(a.substring(i, n), b.substring(0, n - i));
            // Not Swapped case (Same order)
            boolean case2 = solve(a.substring(0, i), b.substring(0, i)) &&
                    solve(a.substring(i, n), b.substring(i, n));

            if (case1 || case2) {
                flag = true;
                break;
            }
        }
        map.put(key, flag);
        return flag;
    }
}

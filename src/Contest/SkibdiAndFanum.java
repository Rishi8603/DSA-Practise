package Contest;

import java.util.*;


public class SkibdiAndFanum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int m = sc.nextInt();
            int[] b = new int[m];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }
            System.out.println(canSort(a, b));
        }
        sc.close();
    }

    // Returns "YES" if it's possible to make the array non-decreasing.
    // Otherwise, returns "NO".

    public static String canSort(int[] a, int[] b) {
        Arrays.sort(b); // sort b in ascending order for binary search

        // 'prev' stores the last chosen value in our final (sorted) array.
        // We start with the smallest possible value.
        long prev = Long.MIN_VALUE;

        // Process each element of a from left to right.
        for (int i = 0; i < a.length; i++) {
            int original = a[i];

            // Option 1: Do nothing.
            // Only valid if the original value is not smaller than prev.
            long option1 = (original >= prev) ? original : Long.MAX_VALUE;

            // Option 2: Update the element.
            // We want b[j] - original >= prev, i.e., b[j] >= prev + original.
            int idx = lowerBound(b, prev + original);
            long option2 = (idx != -1) ? b[idx] - original : Long.MAX_VALUE;

            // Choose the option with the smallest valid final value.
            long chosen = Math.min(option1, option2);
            if (chosen == Long.MAX_VALUE) {
                return "NO";  // neither option worked, so it's impossible
            }

            // Update prev to the value chosen for a[i].
            prev = chosen;
        }
        return "YES";  // all elements processed successfully
    }

    // Binary search: find the first index in b where b[i] >= key.
    // Returns -1 if no such element exists.
    public static int lowerBound(int[] b, long key) {
        int lo = 0, hi = b.length - 1, ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (b[mid] >= key) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}



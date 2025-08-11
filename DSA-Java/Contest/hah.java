package Contest;
import java.util.*;

public class hah {
    public static boolean canTransform(int[] S, int[] T, int k) {
        if (S.length != T.length) return false;
        if (k == 0) {

            Arrays.sort(S);
            Arrays.sort(T);
            return Arrays.equals(S, T);
        }

        Map<Integer, Integer> countS = new HashMap<>();
        Map<Integer, Integer> countT = new HashMap<>();

        for (int x : S) {
            int r = mod(x, k);
            countS.put(r, countS.getOrDefault(r, 0) + 1);
        }
        for (int x : T) {
            int r = mod(x, k);
            countT.put(r, countT.getOrDefault(r, 0) + 1);
        }

        // gather all remainders that appear in either map
        Set<Integer> keys = new HashSet<>();
        keys.addAll(countS.keySet());
        keys.addAll(countT.keySet());

        for (int r : keys) {
            int paired = mod(k - r, k); // k-r modulo k
            int sumS = countS.getOrDefault(r, 0) + countS.getOrDefault(paired, 0);
            int sumT = countT.getOrDefault(r, 0) + countT.getOrDefault(paired, 0);
            if (sumS != sumT) return false;
        }

        return true;
    }

    // helper to get non-negative remainder in [0, k-1]
    private static int mod(int x, int k) {
        int r = x % k;
        if (r < 0) r += k;
        return r;
    }

    public static void main(String[] args) {
        int[] S = {1};
        int[] T = {2};
        int k = 3;

        System.out.println(canTransform(S, T, k) ? "YES" : "NO"); // prints YES
    }
}

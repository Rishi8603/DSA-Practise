package Contest;

import java.util.Scanner;

public class BoilerPlate {
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
        }
        sc.close();
    }
}

package DP;

public class SoupServings {
    public static void main(String[] args) {
        System.out.println(soupServings(100));
    }
    private static final int LIMIT = 200;
    private static final double[][] dp = new double[LIMIT + 1][LIMIT + 1];
    private static boolean computed = false;

    public static double soupServings(int n) {
        if (!computed) {
            for (int i = 0; i <= LIMIT; i++) {
                for (int j = 0; j <= LIMIT; j++) {
                    if (i == 0 && j == 0) dp[i][j] = 0.5;
                    else if (i == 0) dp[i][j] = 1.0;
                    else if (j == 0) dp[i][j] = 0.0;
                    else dp[i][j] = 0.25 * (
                                dp[Math.max(i - 4, 0)][j] +
                                        dp[Math.max(i - 3, 0)][Math.max(j - 1, 0)] +
                                        dp[Math.max(i - 2, 0)][Math.max(j - 2, 0)] +
                                        dp[Math.max(i - 1, 0)][Math.max(j - 3, 0)]
                        );
                }
            }
            computed = true;
        }

        n = (n + 24) / 25;
        if (n >= LIMIT) return 1.0;
        return dp[n][n];
    }
//    private static double[][] t;
//    public static double soupServings(int n) {
//        //we will use here ceiling division concept
//        n=(n+24)/25;
//        t=new double[n+1][n+1];
//        return fun(n, n);
//    }
//    private static double fun(int n1, int n2) {
//        if (n1 <= 0 && n2 <= 0) return 0.5;
//        if (n1 <= 0) return 1.0;
//        if (n2 <= 0) return 0.0;
//
//        if(t[n1][n2]!=0) return t[n1][n2];
//
//        return t[n1][n2]=0.25 * (fun(n1 - 4, n2) + fun(n1 - 3, n2 - 1) + fun(n1 - 2, n2 - 2) + fun(n1 - 1, n2 - 3));
//    }


}

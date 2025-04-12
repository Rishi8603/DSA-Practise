package DP.LCS;

public class lowestCommonSubstring {
    public static void main(String[] args) {

    }
    public static int longestCommonSubstr(String x, String y) {
        int n=x.length();
        int m=y.length();

        int[][] t=new int[n+1][m+1];
        //intiallisation
        for(int i=0;i<t.length;i++){
            for(int j=0;j<t[0].length;j++){
                if(i==0||j==0) t[i][j]=0;
            }
        }

        //main code
        int res=0;
        for(int i=1;i<t.length;i++) {
            for (int j = 1; j < t[0].length; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                    res=Math.max(t[i][j],res);
                } else {
                    t[i][j] =0;
                }
            }
        }

        return res;
    }
}

package DP.LCS;

public class lcsBottomUp {
    public static void main(String[] args) {
        String x="aggtab";
        String y="gxtxayb";
        System.out.println(lcs(x,y,x.length(),y.length()));
    }
    public static int lcs(String x,String y,int n,int m){
        if(n==0||m==0) return 0;
        int[][] t=new int[n+1][m+1];
        
        //main code
        for(int i=1;i<t.length;i++) {
            for (int j = 1; j < t[0].length; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                   t[i][j] = 1 + t[i-1][j-1];
                } else {
                   t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[n][m];
    }
}

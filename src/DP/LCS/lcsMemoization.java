package DP.LCS;
import java.util.*;
public class lcsMemoization {
    public static void main(String[] args) {

    }
    static int[][] t=new int[1001][1001];
    public static int longestCommonSubsequence(String text1, String text2) {
        for(int i=0;i<t.length;i++){
            Arrays.fill(t[i],-1);
        }
        return lcs(text1,text2,text1.length(),text2.length());
    }
    public static int lcs(String x,String y,int n,int m){
        if(n==0||m==0) return 0;
        if(t[n][m]!=-1) return t[n][m];
        //main code
        if(x.charAt(n-1)==y.charAt(m-1)){
            return t[n][m]=1+lcs(x,y,n-1,m-1);
        }else{
            return t[n][m]=Math.max(lcs(x,y,n-1,m),lcs(x,y,n,m-1));
        }
//        return t[n][m];
    }
}

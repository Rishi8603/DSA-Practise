package DP.LCS;

public class printLcsBrute {
    public static void main(String[] args) {
        String a="acbcf";
        String b="abcdaf";
        System.out.println(helper(a,b));
    }
    public static String helper(String a,String b){
        int m=a.length();
        int n=b.length();
        int t[][]=new int[m+1][n+1];
        //fill t table
        lcs(a,b,t);
        //now we will start from t[m][n]
        int i=m,j=n;
        StringBuilder sb=new StringBuilder();
        while(i>0 && j>0){
            if(a.charAt(i-1)==b.charAt(j-1)){
                sb.append(a.charAt(i-1));
                i--;j--;
            }else{
                if(t[i-1][j]>t[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }
        return sb.reverse().toString();
    }
    public static void lcs(String x,String y,int t[][]){
        int m=x.length();
        int n=y.length();
        if(n==0||m==0) return;
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
    }
}

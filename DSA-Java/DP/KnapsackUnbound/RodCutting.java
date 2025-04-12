package DP.KnapsackUnbound;

public class RodCutting {
    public static void main(String[] args) {
        int[] price={1,3,4,5};
        System.out.println(cutRod(price));
    }
    public static int cutRod(int[] price) {
        int n=price.length;
        int[] length =new int[n];
        for(int i=0;i<n;i++){
            length[i]=i+1;
        }
        int[][] t=new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(length[i-1]<=j){
                    t[i][j]=Math.max(price[i-1]+t[i][j-length[i-1]],t[i-1][j]);
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][n];
    }
}

package DP.MCM;

import java.util.Arrays;

public class mcmTopDown {
    public static void main(String[] args) {
        int[] arr={10,30,5,60};
        System.out.println(matrixMultiplication(arr));
    }
    static int matrixMultiplication(int arr[]) {
        int n=arr.length;
        for(int i=0;i<t.length;i++){
            Arrays.fill(t[i],-1);
        }
        return solve(arr,1,n-1);
    }
    static int[][] t=new int[1001][1001];
    public static int solve(int[] arr,int i,int j){
        //base cond
        if(i>=j) return 0;
        if(t[i][j]!=-1) return t[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int tempans=solve(arr,i,k)+solve(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
            if(tempans<min){
                min=tempans;
            }
        }
        return t[i][j]=min;
    }
}

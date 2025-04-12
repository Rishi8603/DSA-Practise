package DP.Knapsack01;

import java.util.*;

public class Knapsack01TopDown {
    public static void main(String[] args) {
        int[] wt={4,5,1};
        int[] val={1,2,3};
        System.out.println(knapsack(4,val,wt));
    }
    static int[][] t;
    static int knapsack(int W, int val[], int wt[]) {
        t=new int[wt.length+1][W+1];
        for(int i=0;i<t.length;i++){
            Arrays.fill(t[i],-1);
        }
        System.out.println(Arrays.deepToString(t));
        int n=val.length;
        return knapsack1(wt,val,n,W);
    }
    static int knapsack1(int[] wt,int[] val,int n,int cap){
        if(n==0 || cap ==0){
            return 0;
        }
        if(t[n][cap]!=-1) return t[n][cap];
        if(wt[n-1]<= cap){
            return t[n][cap]=Math.max(val[n-1]+knapsack1(wt,val,n-1, cap -wt[n-1]),knapsack1(wt,val,n-1, cap));
        }else{
            return t[n][cap]=knapsack1(wt,val,n-1, cap);
        }
    }
}

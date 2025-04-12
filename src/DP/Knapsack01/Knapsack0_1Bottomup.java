package DP.Knapsack01;

import java.util.Arrays;

public class Knapsack0_1Bottomup {
    public static void main(String[] args) {
        int[] wt={5,2,4,3};
        int[] val={10,30,40,50};
        System.out.println(knapsack(5,val,wt));
    }
    static int knapsack(int W, int val[], int wt[]) {
        int n=wt.length;
        int[][] t =new int[n+1][W+1];
        //initiallisation
        for(int i=0;i<t.length;i++){
            for(int j=0;j<t[0].length;j++){
                if(i==0 || j==0){
                    t[i][j]=0;
                }
            }
        }

        //main code
        for(int i = 1; i < t.length; i++){
            for(int j = 1; j < t[0].length; j++){
                // Check if weight of current item (wt[i-1]) is <= current capacity j.
                if (wt[i-1] <= j) {
                    // Choice: Either include the item or don’t include it.
                    // Corrected: use j - wt[i-1] instead of W-wt[i-1]
                    t[i][j] = Math.max(val[i-1] + t[i-1][j - wt[i-1]], t[i-1][j]);
                } else {
                    // Cannot take the item because it's too heavy for the current capacity.
                    t[i][j] = t[i-1][j];
                }
            }
        }

        System.out.println(Arrays.deepToString(t));

        return t[n][W];
    }
}

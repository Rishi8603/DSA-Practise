package DP.Knapsack01;

import java.util.ArrayList;

public class MinSubsetSumDiff {
    public static void main(String[] args) {
        int[] nums={1,6,2,4};
        System.out.println(minDifference(nums));
    }
    public static int minDifference(int[] nums) {

        int n=nums.length;int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
        }
        boolean[][] t=new boolean[n+1][sum+1];
        //so first we'll do initiallisation
        for(int i=0;i<n+1;i++){
            for(int j=0;j<t[0].length;j++){
                if(i==0){
                    t[i][j]=false;
                }
                if(j==0){
                    t[i][j]=true;
                }
            }
        }
        //main code
        for(int i=1;i<n+1;i++){
            for(int j=1;j<t[0].length;j++){
                if(nums[i-1]<=j){//connecting dots-->MAX changes to OR here and also as VAL[] is not given so ignore it
                    t[i][j]=t[i-1][j-nums[i-1]] || t[i-1][j];
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<=t[0].length/2;i++){
            if(t[n][i]==true) list.add(i);
        }
        System.out.println(list);
        int min=Integer.MAX_VALUE;
        for(int k=0;k<list.size();k++){
            min=Math.min(min,sum-2*list.get(k));
        }
        return Math.abs(min);

    }
}

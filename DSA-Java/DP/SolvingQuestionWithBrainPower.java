package DP;

import java.util.Arrays;

public class SolvingQuestionWithBrainPower {
    public static void main(String[] args) {
        int[][] arr={{1,1},{2,2},{3,3},{4,4},{5,5}};
        System.out.println(mostPoints(arr));
    }
//    static int ans;
    static int[] t;
    public  static long mostPoints(int[][] questions) {
        int n=questions.length;
        t=new int[n+1];
        Arrays.fill(t,-1);
        return solve(questions,0);
    }
    public static int solve(int[][] questions,int i){
        //base condition
        if(i>=questions.length) return 0;
        if(t[i]!=-1) return t[i];
        //main code
        return t[i]=Math.max(questions[i][0]+solve(questions,i+questions[i][1]+1),solve(questions,i+1));
    }
}

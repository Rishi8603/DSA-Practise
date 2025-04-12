package DP.MCM;
import java.util.*;
public class EggDroping {
    public static void main(String[] args) {

    }
    static int[][] t;
    public int superEggDrop(int k, int n) {
        t=new int[k+1][n+1];
        for(int i=0;i<k+1;i++){
            Arrays.fill(t[i],-1);
        }
        return solve(k,n);
    }
    public int solve(int e,int f){
        //base condition
        if(f==0||f==1) return f;
        if(e==1) return f;

        //memoization
        if(t[e][f]!=-1) return t[e][f];

        //main code
        int min=Integer.MAX_VALUE;
        //use binary search
        int l=1,r=f;
        while(l<=r){
            int mid=(l+r)/2;
            int left = solve(e-1,mid-1);
            int right = solve(e,f-mid);
            int temp = 1 + Math.max(left,right);

            if(left<right) {
                l=mid+1;
            }else {
                r=mid-1;
            }
            min = Math.min(min,temp);
        }
        return t[e][f]=min;
    }
}

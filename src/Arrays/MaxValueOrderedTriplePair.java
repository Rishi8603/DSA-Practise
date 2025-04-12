package Arrays;

import java.util.Arrays;

public class MaxValueOrderedTriplePair {
    public static void main(String[] args) {
        int[] arr={18,15,8,13,10,9,17,10,2,16,17};
        System.out.println(maximumTripletValue(arr));
    }
    public static long maximumTripletValue(int[] nums) {
        int n=nums.length;
        long ans=0;
        int[] maxBefore =new int[n];
        int maxB=Integer.MIN_VALUE;
        for(int j = 1; j <n; j++){
            maxBefore[j]=Math.max(maxB,nums[j-1]);
            maxB=maxBefore[j];
        }
        int[] maxAfter=new int[n];
        int maxA =Integer.MIN_VALUE;
        for(int j = n-2; j >=0; j--){
            maxAfter[j]=Math.max(maxA,nums[j+1]);
            maxA =maxAfter[j];
        }
//        System.out.println(Arrays.toString(maxAfter));
//        System.out.println(Arrays.toString(maxBefore));
        for(int j=1;j<n;j++){
            ans=Math.max(ans,(long)(maxBefore[j]-nums[j])*maxAfter[j]);
        }
//        for(int i=0;i<n;i++){
//            for(int j=i+1;j<n;j++){
//                for(int k=j+1;k<n;k++){
//                    long temp= (long) (nums[i] - nums[j]) *nums[k];
//                    ans=Math.max(ans,temp);
//                }
//            }
//        }
        if(ans<0) return 0;
        else return ans;
    }
}

package SlidingWindow;

public class MaximumSumSubarray {
    public static void main(String[] args) {
        int[] arr={30,20,1,3,-40,80,10};
        int k=3;
        int n=arr.length;
        int maxSum=0;
//        for (int i = 0; i < n-k+1; i++) {
//            int sum=0;
//            for (int j = i; j<i+k; j++) {
//                sum+=arr[j];
//            }
//            maxSum=Math.max(maxSum,sum);
//        }

        //sliding window
        int left =0, right =k-1,sum=0;
        for (int l = 0; l<k; l++) {//0(k) k times
            sum+=arr[l];
        }
        maxSum=sum;
        left++;
        right++;
        while(right <n){// n-k times
            sum=sum-arr[left -1]+arr[right];
            maxSum=Math.max(maxSum,sum);
            left++;
            right++;
        }
        System.out.println(maxSum);
    }
}

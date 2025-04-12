package SlidingWindow;

public class NumberOfSubarrayGreaterThanThresold {
    public static void main(String[] args) {
        int[] arr={2,2,2,2,5,5,5,8};
        int k=3;
        int thresold=4;
        System.out.println(numOfSubarrays(arr,k,thresold));
    }
    public static int numOfSubarrays(int[] arr, int k, int threshold){
        //sliding window concept
        int i=0,j=k-1,sum=0,maxSum=0,n=arr.length,count=0;
        for (int l = 0; l <= k-1; l++) {
            sum=(sum+arr[l]);
        }
        if(sum/k>=threshold) count++;
        i++;j++;
        while(j<n){
            sum=(sum-arr[i-1]+arr[j]);
            if(sum/k>=threshold) count++;
            i++;j++;
        }

        //System.out.println(maxSum);
        return count;
    }
}

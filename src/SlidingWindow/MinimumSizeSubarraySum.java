package SlidingWindow;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] arr={2,3,1,2,4,3};
        int target=7;
//        System.out.println(BruteForce(target,arr));
        System.out.println(Optimal(target,arr));
    }
    public static int Optimal(int target,int[] arr){
        int n=arr.length,minLen=Integer.MAX_VALUE;
        int left =0, right =0,sum=0;
        while(right <n && sum<target){//first window
            sum+=arr[right];
            right++;
        }right--;// ye bs j ek br aage chala jata hei, isliye usko piche lane ke liye
        //sliding window
        System.out.println(sum);
        while(left <n && right <n){
            int len= right - left +1;
            if(sum>=target) {
                minLen=Math.min(minLen,len);
            }
            sum=sum-arr[left];
            left++;
            right++;
            while (right <n && sum<target){
                sum+=arr[right];
                right++;
            }
            right--;
        }
        if(minLen==Integer.MAX_VALUE) return 0;
        return minLen;
    }
    public static int BruteForce(int target,int[] arr){
        int n=arr.length,minLen=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum=0,j=i;
            while(j<n && sum<target){
                sum+=arr[j];
                j++;
            }
            j--;
            int length=j-i+1;
            if(sum>=target) minLen=Math.min(minLen,length);
        }
        if(minLen==Integer.MAX_VALUE) return 0;
        return minLen;
    }
}

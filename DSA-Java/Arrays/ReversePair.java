package Arrays;

public class ReversePair {
    public static void main(String[] args) {
        int[] nums={1,3,2,3,1};
        System.out.println(reversePairs(nums));
    }
    public static int reversePairs(int[] nums){
        return mergeSort(nums, 0, nums.length - 1);
    }
    // Modified mergeSort to work with indices instead of subarrays
    public static int mergeSort(int[] nums, int start, int end) {
        if (start >= end) return 0;

        int mid = (start + end) / 2;
        int count = mergeSort(nums, start, mid);
        count += mergeSort(nums, mid + 1, end);
        count += merge(nums, start, mid, end);

        return count;
    }
    // Merge and count reverse pairs
    public static int merge(int[] nums,int start,int mid,int end){
        int count = 0;
        int j = mid + 1;

        // Count reverse pairs
        for (int i = start; i <= mid; i++) {
            while (j <= end && (long)nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        int[] mix=new int[end-start+1];
        int i = start, k = 0;
        j = mid + 1;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                mix[k++] = nums[i++];
            } else {
                mix[k++] = nums[j++];
            }
        }

        while (i <= mid) mix[k++] = nums[i++];
        while (j <= end) mix[k++] = nums[j++];

        // Copy back to original array
        for (i = start; i <= end; i++) {
            nums[i] = mix[i - start];
        }

        return count;
    }
    //bruteforce
//    public static int reversePairs(int[] nums) {
//        int count=0;
//        for(int i=0;i<nums.length;i++){
//            for(int j=i+1;j<nums.length;j++){
//                if((long) nums[i]>2L*(long) nums[j]){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
}


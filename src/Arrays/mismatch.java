package Arrays;

import java.util.Arrays;

public class mismatch {
    public static void main(String[] args) {
        int[] nums = {1,1};
        int[] ans=mismatch(nums);
        System.out.println(Arrays.toString(ans));
    }
    static int[] mismatch(int[] nums){
        int i=0;
        while(i<nums.length){
            int correctindex=nums[i]-1;
            if (nums[i]!=nums[correctindex]) {
                swap(i,correctindex,nums);
            }else{
                i++;
            }
        }

        //search missing number
        int[] ans={-1,-1};
        for(int index=0;index<nums.length;index++){
            if(nums[index]!=index+1) {
                ans[0]=nums[index];
                ans[1]=index+1;
            }
        }
        return ans;
    }
    static void swap(int first, int second, int[] arr) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

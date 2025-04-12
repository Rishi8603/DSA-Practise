package Arrays;

import java.util.Arrays;

public class firstandlast {
    public static void main(String[] args) {
        int[] nums={5,7,8,8,8,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(fun1(nums,8)));
    }
    static int[] fun1(int[] nums,int target){
        int[] ans={-1,-1};
        ans[0] = searchRange(nums, target, true);

        // Find the last occurrence if the first Main is found
        if (ans[0] != -1) {
            ans[1] = searchRange(nums, target, false);
        }

        return ans;
    }

    static int searchRange(int[] nums,int target,boolean answer){
        int index=-1;
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;

            if(target<nums[mid]){
                end=mid-1;
            }
            else if(target>nums[mid]){
                start=mid+1;
            }
            else if(target==nums[mid]){
                index=mid;
                if(answer) {
                    end =mid-1;
                }else{
                    start=mid+1;
                }
            }
        }

        return index;
    }
}

package Arrays;

import java.util.*;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums){
        int ui=0;
        int i=1;
        while(i<nums.length){
            if(nums[ui]==0){
                if(nums[i]==0){
                    i++;
                }else {
                    nums[ui] = nums[i];
                    nums[i] = 0;
                    ui++;
                    i++;
                }
            }else if(nums[i]==0){
                ui=i;
                i++;
            }else {
                i++;
            }
        }
    }
}

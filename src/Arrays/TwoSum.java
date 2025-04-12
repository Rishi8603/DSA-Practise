package Arrays;
import java.util.*;
public class TwoSum {
    public static void main(String[] args) {
        int[] nums={2,5,5,11};
        int target=10;
        System.out.println(Arrays.toString(twosum(nums,target)));
    }
    public static int[] twosum(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length;j++) {
                if(nums[i]+nums[j]==target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }
}

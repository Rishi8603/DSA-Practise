package Arrays;

import java.util.ArrayList;
import java.util.*;

public class RemovingDuplicates {
    public static void main(String[] args) {
        int[] nums={0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums){
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i <nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]==nums[j]){
                    list.add(nums[i]);
                }
            }
        }
        return list.size();
    }
}

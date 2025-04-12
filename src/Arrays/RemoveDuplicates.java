package Arrays;

import java.util.ArrayList;
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums={0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int uniqueIndex = 0; // Pointer for the unique elements
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++; // Move the pointer for unique elements
                nums[uniqueIndex] = nums[i]; // Update the array in place
            }
        }
        return uniqueIndex + 1; // Length of the unique array
    }
 //NOT GOOD LOGIC BELOW
//    public static int removeDuplicates(int[] nums){
//        ArrayList<Integer> list=new ArrayList<>();
//        int i=0;
//        while (i < nums.length ){
//            if(!(i==nums.length-1)&&nums[i]==nums[i+1]){
//                if(i==0||!((nums[i-1]) ==nums[i])) {
//                    list.add(nums[i]);
//                }
//                i++;
//            }else if(!(i==nums.length-1)&&i==0||!((nums[i-1]) ==nums[i])){
//                list.add(nums[i]);
//                i++;
//            }else if((i==nums.length-1) && !(nums[i-1]==nums[i])){
//                list.add(nums[i]);
//                i++;
//            }else {
//                i++;
//            }
//        }
//        System.out.println(list);
//        System.out.println(list.size());
//        return list.size();
//    }
}

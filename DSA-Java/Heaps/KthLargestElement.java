package Heaps;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr={3,2,1,5,6,4};
        System.out.println(findKthLargest(arr,2));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minH=new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            minH.add(nums[i]);
            if(minH.size()>k){
                minH.remove();
            }
        }
        return minH.peek();
//        PriorityQueue<Integer>  maxH=new PriorityQueue<>(Collections.reverseOrder());
//        for(int i=0;i<nums.length;i++){
//            maxH.add(nums[i]);
//            if(maxH.size()>k){
//                maxH.remove();
//            }
//        }
//        return maxH.peek();
    }
}

package Heaps;

import java.util.Collections;
import java.util.*;
class KthLargest {
    public KthLargest(int k, int[] nums) {
        temp=k;
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=nums.length-temp;i--){
            pq.add(nums[i]);
        }
    }
    int temp=0;
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    public int add(int val) {
       pq.add(val);
       if(pq.size()>temp) {
           pq.remove();
           return pq.peek();
       }else{
           return pq.peek();
       }
    }
}

public class KthLargestEleInStream {
    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30, 40, 50};
        int[] arr2 =  Arrays.copyOf(arr1, arr1.length+1);
        arr2[arr2.length-1]=5;
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}

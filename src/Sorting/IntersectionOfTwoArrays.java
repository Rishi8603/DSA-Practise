package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));
    }
    public static int[] intersection(int[] nums1,int[] nums2){
        ArrayList<Integer> list=new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int j = 0;
        int i=0;
        while ( j < nums2.length) {
            int start=0;
            int end=nums1.length-1;
            while(start<=end){
            int mid=start+(end-start)/2;
                if(!list.isEmpty()&&list.get(i-1)==nums2[j]){
                    j++;
                    break;
                }else if(nums1[mid]==nums2[j]){
                    list.add(nums1[mid]);
                    i++;
                    j++;
                    break;
                }else if((nums1[mid])>nums2[j]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
            if (start > end) {
                // If no match is found, move to the next element in nums2
                j++;
            }
        }
        int[] arr= convertArrayListToArray(list);
        return arr;
    }
    public static int[] convertArrayListToArray(ArrayList<Integer> list) {
        int[] array = new int[list.size()]; // Create an array of the same size
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i); // Copy elements Main by Main
        }
        return array; // Return the array
    }
}

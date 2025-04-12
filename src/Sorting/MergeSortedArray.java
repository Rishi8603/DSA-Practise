package Sorting;
import java.util.*;
import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] num1 ={1,2,3,0,0,0};
        int[] num2={2,5,6};
        merge(num1,num1.length,num2,num2.length);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int nums=Math.min(nums1.length, nums2.length);
        int[] arr= Arrays.copyOf(nums1, nums1.length);
        int i=0;
        int j=0;
        int k=0;
        while (i<(arr.length-nums2.length) && j< nums2.length) {
            if(arr[i]< nums2[j]){
                nums1[k]=arr[i];
                i++;
                k++;
            }else{
                nums1[k]= nums2[j];
                j++;
                k++;
            }
        }
        while(i<arr.length && arr[i]!=0 ){
            nums1[k]=arr[i];
            i++;
            k++;
        }
        while(j< nums2.length){
            nums1[k]= nums2[j];
            j++;
            k++;
        }
        System.out.println(Arrays.toString(nums1));
    }

}

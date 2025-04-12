package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class allduplicatesinarray {
    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        List<Integer> anss = findDuplicates(nums);
        System.out.println(anss);
    }
    public static List<Integer> findDuplicates(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(i, correct, arr);
            } else {
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index+1) {
                ans.add(arr[index]);
            }
        }

        return ans;
    }

    static void swap(int first,int second,int[] arr){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;

    }

    public static class reverse {
        public static void main(String[] args){
            int[] arr={1,2,3,4};
            rev(arr);
        }
        static void rev(int[] arr) {
            int start=0;
            int end=arr.length-1;
            int temp=arr[end];
            arr[end]=arr[start];
            arr[start]=temp;
            start=start+1;
            end=end-1;

        }
    }

    public static class tozero {
        public static void main(String[] args) {
    //        System.out.println(numberofSteps(123));
            List<String> list = new ArrayList<>();
            list.add("Apple");
            List<String> moreFruits = Arrays.asList("Banana", "Orange");
            list.addAll(moreFruits);  // Adds all elements from moreFruits
            System.out.println(list);
        }

    //    public static int numberofSteps(int n){
    //        return helper(n,0);
    //    }
    //    public static int helper(int n,int c){
    //        if(n%2==0 && n!=0){
    //            return helper(n/2,c=c+1);
    //        }
    //        else if(n%2!=0){
    //            return helper(n-1,c=c+1);
    //        }
    //        else if(n==0){
    //            return c;
    //        }
    //        return c;
        //}
    }
}

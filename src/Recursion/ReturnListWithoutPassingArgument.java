package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class ReturnListWithoutPassingArgument {
    public static void main(String[] args) {
        int[] arr={2,3,1,4,4,5};
        System.out.println(findAllIdx(arr,4,0));
    }
    public static ArrayList<Integer> findAllIdx(int[] arr, int target, int i){
        ArrayList<Integer> list=new ArrayList<>();
        if(i==arr.length) return list;
        if(arr[i]== target) list.add(i);
        ArrayList<Integer> ansFromBelowCalls=findAllIdx(arr,target,i+1);
        list.addAll(ansFromBelowCalls);
        return list;
    }
}

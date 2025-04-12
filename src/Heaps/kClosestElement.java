package Heaps;

import java.util.*;

public class kClosestElement {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(findClosestElements(arr,4,3));
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list=new ArrayList<>();
        PriorityQueue<PairMax> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(new PairMax(Math.abs(arr[i]-x),arr[i]));
            if(maxHeap.size()>k) {
                maxHeap.remove();
            }
        }
        while(maxHeap.size()!=0){
            list.add(maxHeap.remove().second);
        }
        Collections.sort(list);
        return list;
    }

}

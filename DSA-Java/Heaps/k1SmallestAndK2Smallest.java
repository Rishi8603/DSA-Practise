package Heaps;

import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;

public class k1SmallestAndK2Smallest {
    public static void main(String[] args) {
        long[] arr={20 ,8 ,22, 4 ,12 ,10 ,14};
        System.out.println(sumBetweenTwoKth(arr,arr.length,3,6));
    }
    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2) {
        long sum=0;
        // Comparator for max heap: b.getValue() - a.getValue() // Compare values when keys are equal
        PriorityQueue<Map.Entry<Long, Integer>> maxH1 = new PriorityQueue<>((a, b) -> b.getKey().compareTo(a.getKey())) ;

        for (int i = 0; i < A.length; i++) {
            maxH1.add(new AbstractMap.SimpleEntry<>(A[i],i));
            if(maxH1.size()>K1){
                maxH1.remove();
            }
        }
        long temp3= maxH1.peek().getKey();

        PriorityQueue<Map.Entry<Long, Integer>> maxH2 = new PriorityQueue<>((a, b) -> b.getKey().compareTo(a.getKey())) ;
        for (int i = 0; i < A.length; i++) {
            maxH2.add(new AbstractMap.SimpleEntry<>(A[i],i));
            if(maxH2.size()>K2){
                maxH2.remove();
            }
        }
        long temp2= maxH2.peek().getKey();

        for (long i = 0; i < A.length; i++) {
            if(A[(int) i]>temp3 && A[(int) i]<temp2) sum=sum+A[(int)i];
        }
        return sum;
    }
}

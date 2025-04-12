package Greedy;

import java.util.*;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] interval={{1,2}, {2,3}, {3,4}, {-100,-2}, {5,7}};
        System.out.println(eraseOverlapIntervals(interval));
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        System.out.println(Arrays.deepToString(intervals));
        int count=0;
        int lastEnd=Integer.MIN_VALUE;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]<lastEnd){
                count++;
            }else{
                lastEnd=intervals[i][1];
            }
        }
        return count;
    }
}

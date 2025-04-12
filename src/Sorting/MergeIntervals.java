package Sorting;

import java.util.*;

public class MergeIntervals {
    static class Pair{
        int first;int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{6,11}, {7,13}, {8,9}, {5,8}, {3,13}, {11,13}, {1,3}, {5,10}, {8,13}, {3,9}};

        System.out.println(Arrays.deepToString(merge(intervals)));
    }
    public static int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.println(Arrays.deepToString(intervals));
        ArrayList<Pair> list=new ArrayList<>();
        int start=intervals[0][0];int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(end>=intervals[i][0]){
                end=Math.max(intervals[i][1],end);
            }else{
                list.add(new Pair(start,end));
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        //add last pair
        list.add(new Pair(start,end));
//        System.out.println(list);
        //now converting arraylist into 2d array as return type is 2d array given
        int[][] array=new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            Pair p=list.get(i);
            array[i][0]=p.first;
            array[i][1]=p.second;
        }
        return array;
    }
}

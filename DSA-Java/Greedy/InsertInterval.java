package Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval {
    static class Pair{
        int first,second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public static void main(String[] args) {
        int[][] interval={{1,2}, {3,4}, {6,7}, {8,10}, {12,16}};
        int[] newinterval={5,8};
        System.out.println(Arrays.deepToString(insert(interval,newinterval)));
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<Pair> ans=new ArrayList<>();
        int n=intervals.length;
        int i=0;
        //left
        while(i<n && intervals[i][1]<newInterval[0]){
            ans.add(new Pair(intervals[i][0],intervals[i][1]));
            i++;
        }
        //overlapping
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        ans.add(new Pair(newInterval[0],newInterval[1]));
        //right
        while(i<n){
            ans.add(new Pair(intervals[i][0],intervals[i][1]));
            i++;
        }

        int[][] a=new int[ans.size()][2];
        for(int j = 0; j <ans.size(); j++){
            a[j][0]=ans.get(j).first;
            a[j][1]=ans.get(j).second;
        }
        return a;
    }
}

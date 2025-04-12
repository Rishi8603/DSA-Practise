package Heaps;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class kClosestPointToOrigin {
    public static void main(String[] args) {
        int[][] arr={{1,3} ,{-2,2}};
        System.out.println(Arrays.deepToString(kClosest(arr,1)));
    }
    public static int[][] kClosest(int[][] points, int k) {
        int[][] ans=new int[k][2];
        PriorityQueue<Map.Entry<Integer,Map.Entry<Integer,Integer>>> maxH = new PriorityQueue<>(
                (a, b) -> b.getKey() - a.getKey()
        );
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length-1; j++) {
                int x=points[i][j];
                int y=points[i][j+1];
                int dist=x*x+y*y;
                maxH.add(new AbstractMap.SimpleEntry<>(dist,new AbstractMap.SimpleEntry<>(x, y)));

                if(maxH.size()>k){
                    maxH.remove();
                }
            }
        }
        while(maxH.size()!=0){
            Map.Entry<Integer, Map.Entry<Integer, Integer>> entry = maxH.poll();
            int x = entry.getValue().getKey();
            int y = entry.getValue().getValue();
            ans[k - 1][0] = x;  // Use k - 1 since we are decreasing k
            ans[k - 1][1] = y;
            k--;
        }
        return ans;
    }
}

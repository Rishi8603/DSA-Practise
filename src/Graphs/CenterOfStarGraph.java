package Graphs;

import java.util.*;
import java.util.PriorityQueue;

public class CenterOfStarGraph {
    public static void main(String[] args) {
        int[][] edges={{1,2}, {5,1}, {1,3}, {1,4}};
        System.out.println(findCenter(edges));
    }
    public static int findCenter(int[][] edges) {
        //star graph hei...isliye O(1) mein hi ho jayega...as center of
        //this graph is connected to all 
        if(edges[0][0]==edges[1][0]||edges[0][0]==edges[1][1]){
            return edges[0][0];
        }else{
            return edges[0][1];
        }
    }
//    static class pair implements Comparable<pair>{
//        int first;
//        int second;
//        pair(int first, int second){
//            this.first=first;
//            this.second=second;
//        }
//
//        public int compareTo(pair other){
//            return other.second-this.second;
//        }
//    }
//    public static int findCenter(int[][] edges) {
//        HashMap<Integer,Integer> map=new HashMap<>();
//        PriorityQueue<pair> pq=new PriorityQueue<>();
//        for(int i=0;i<edges.length;i++){
//            int temp1=edges[i][0];
//            int temp2=edges[i][1];
//            map.put(temp1, map.getOrDefault(temp1,0)+1);
//            map.put(temp2, map.getOrDefault(temp2,0)+1);
//        }
//        System.out.println(map);
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            pq.add(new pair(entry.getKey(),entry.getValue()));
//        }
//
//        return pq.peek().first;
//    }
}

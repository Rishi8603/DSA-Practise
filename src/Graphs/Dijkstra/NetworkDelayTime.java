package Graphs.Dijkstra;

import java.util.*;

public class NetworkDelayTime {
//    static class Pair implements Comparable<Pair>{
        static class Pair{
        int node;
        int time;
        Pair(int node, int time){
            this.node=node;
            this.time=time;
        }

        @Override
        public String toString() {
            return "("+node+", "+time+")";
        }

//        @Override
//        public int compareTo(Pair other) {
//            int diffCompare=Integer.compare(this.time,other.time);
//            return diffCompare;
//        }
    }
    public static void main(String[] args) {
        int[][] time={{1, 2, 1},
                {2, 3, 2},
                {1, 3, 1}};
        System.out.println(networkDelayTime(time,3,2));
    }
    public static int networkDelayTime(int[][] times, int n, int src) {
        //first we will make adj list
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        //updation of adj
        for (int i = 0; i < times.length; i++) {
            int x=times[i][0];
            int y=times[i][1];
            int time=times[i][2];
//            System.out.print("{"+x+"->"+"{"+y+","+time+"}"+"}");
            adj.get(x).add(new Pair(y,time));
        }
        System.out.println(adj);
        //IMPORTANT
        //NOTE code to easy hei, but last mein maxheap use kr rhe the max time return krne ke liye
        //but simple array mein hi traverse kr ke shi hoga

        // Max-Heap (Sorts by time in descending order when node is different)
//        PriorityQueue<Pair> maxH = new PriorityQueue<>((a, b) -> {
//            if (a.node != b.node) {
//                return Integer.compare(b.time, a.time); // Max-Heap
//            }else{
//                return Integer.compare(a.time,b.time); // Min-Heap
//            }
//        });
//        Map<Integer, Pair> map = new HashMap<>();

        //now apply dijkstra algo
        int[] samay=new int[n+1];
        Arrays.fill(samay,Integer.MAX_VALUE);
        samay[src]=0;
//        PriorityQueue<Pair> pq=new PriorityQueue<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
        pq.add(new Pair(src,0));
        while(pq.size()>0){
            Pair top=pq.remove();
            for(Pair current :adj.get(top.node)){
                int totalTime=top.time+ current.time;
                if(totalTime<samay[current.node]){
                    samay[current.node]=totalTime;
                    System.out.print("("+current.node+","+totalTime+")");
//                    addOrUpdate(maxH, map, new Pair(current.node, totalTime));
                    pq.add(new Pair(current.node,totalTime));
                }
            }
        }

        System.out.println();
        System.out.println(Arrays.toString(samay));
        int temp=Integer.MIN_VALUE;
        for(int i=1;i<samay.length;i++){
            if(samay[i]>temp) temp=samay[i];
        }
        if(temp==0 || temp==Integer.MAX_VALUE) return-1;
        else return temp;
//        if(maxH.size()>0 && maxH.size()>=n-1) {
//            return maxH.peek().time;
//        }
//        else return -1;
    }
//    static void addOrUpdate(PriorityQueue<Pair> heap, Map<Integer, Pair> map, Pair newPair) {
//        if (map.containsKey(newPair.node)) {
//            heap.remove(map.get(newPair.node)); // O(N), since PriorityQueue does not support fast removal
//        }
//        heap.add(newPair); // O(log N)
//        map.put(newPair.node, newPair);
//    }
}

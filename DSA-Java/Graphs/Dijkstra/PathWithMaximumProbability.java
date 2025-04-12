package Graphs.Dijkstra;

import java.util.*;
import java.util.PriorityQueue;

public class PathWithMaximumProbability {
    static class Pair{
        int node;
        double prob;
        Pair(int node, double prob){
            this.node=node;
            this.prob =prob;
        }

        @Override
        public String toString() {
            return "("+node+", "+ prob +")";
        }
    }
    public static void main(String[] args) {
        int[][] edge={{0,1}, {1,2}, {0,2}};
        double[] p={0.5,0.5,0.2};
        System.out.println(maxProbability(3,edge,p,0,2));
    }
    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        //first make a adj list (modified wala adj list bnao) jo dijkstra mein use ho
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }
        //updation of adj
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1],succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],succProb[i]));
        }
        System.out.println(adj);
//        PriorityQueue<Pair> pq=new PriorityQueue<>();
        //we should prefer lambda comparator over custom comparator while
        //implementing heap .....below Main is lambda comp..
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));

        double[] prob=new double[n];
        prob[start_node]=1;
        pq.add(new Pair(start_node,1));
        while(pq.size()>0){
           Pair top=pq.remove();
            for(Pair current :adj.get(top.node)){
                double totalProb=top.prob* current.prob;
                if(totalProb>prob[current.node]){
                    prob[current.node]=totalProb;
                    System.out.print("("+current.node+","+totalProb+")");
//                    maxH.add(new Pair(current.node,totalTime));
//                    addOrUpdate(maxH, map, new Pair(current.node, totalTime));
                    pq.add(new Pair(current.node,totalProb));
                }
            }
        }
//        System.out.println(Arrays.toString(prob));

        return prob[end_node];
    }
}

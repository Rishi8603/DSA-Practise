package Graphs.DSU;

import java.util.*;

public class MinCostToConnectUsingKruskalAlgo {
    public static void main(String[] args) {

    }
    static int[] parent;
    static int[] size;
    public static int leader(int a){//recursion to find group leader
        if(parent[a]==a) return a ;
        int leader= leader(parent[a]);
        parent[a]=leader;
        return leader;
    }
    public static void union(int a,int b){
        int leaderA= leader(a);
        int leaderB= leader(b);
        //now we can either make a ka parent b or b ka parent a ..it's our choice
        //make parent of b as a
        if(leaderA!=leaderB) {
            if(size[leaderA]>size[leaderB]) { // a should be parent of b
                parent[leaderB] = leaderA;
                size[leaderA]+=size[leaderB];
            }else{
                parent[leaderA] = leaderB;
                size[leaderB]+=size[leaderA];
            }
        }
    }
    public class edge implements Comparable<edge>{
        int u,v, dist;
        edge(int u, int v, int dist){
            this.u=u;
            this.v=v;
            this.dist=dist;
        }
        public int compareTo(edge other){
            if(this.dist==other.dist) return this.u- other.u;
            else return this.dist- other.dist;
        }
    }
    //using arraylist to store edges
    public int minCostConnectPoints(int[][] points) {
        //ye maan ke chalo ki every node is connected to other node
        int n=points.length;
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
            size[i]=i;
        }
        ArrayList<edge> list=new ArrayList<>();
        for (int u = 0; u <n ; u++) {
            for (int v = u+1; v < n; v++) {
                //u to v edge
                int x1=points[u][0],y1=points[u][1];
                int x2=points[v][0],y2=points[v][1];
                int dist=Math.abs(x1-x2)+Math.abs(y1-y2);
                list.add(new edge(u,v,dist));
            }
        }
        Collections.sort(list);
        //now apply KRUSKAL ALGO
        int cost=0;
        for(int i=0;i<list.size();i++){
            edge top=list.get(i);
            int u=top.u,v=top.v,dist=top.dist;
            if(leader(u)!=leader(v)){
                cost+=dist;
                union(u,v);
            }
        }
        return cost;
    }
    //using priority queue to store edges
//    public int minCostConnectPoints(int[][] points) {
//        //ye maan ke chalo ki every node is connected to other node
//        int n=points.length;
//        parent=new int[n];
//        size=new int[n];
//        for(int i=0;i<parent.length;i++){
//            parent[i]=i;
//            size[i]=i;
//        }
//        PriorityQueue<edge> pq=new PriorityQueue<>();
//        for (int u = 0; u <n ; u++) {
//            for (int v = u+1; v < n; v++) {
//                //u to v edge
//                int x1=points[u][0],y1=points[u][1];
//                int x2=points[v][0],y2=points[v][1];
//                int dist=Math.abs(x1-x2)+Math.abs(y1-y2);
//                pq.add(new edge(u,v,dist));
//            }
//        }
//        //now apply KRUSKAL ALGO
//        int cost=0;
//        while(pq.size()>0){
//            edge top=pq.remove();
//            int u=top.u,v=top.v,dist=top.dist;
//            if(leader(u)!=leader(v)){
//                cost+=dist;
//                union(u,v);
//            }
//        }
//        return cost;
//    }
}

package Graphs.TopologicalSort;

import java.util.*;

public class FindEventualSafeStates {
    public static void main(String[] args) {
       int[][] arr={{1,2},{2,3},{5},{0},{5},{},{}};
       System.out.println(eventualSafeNodes(arr));
    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        //we need to make a reversed graph
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        int[] in=new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                int x=  graph[i][j];
                adj.get(x).add(i);
                in[i]++;
            }
        }
        System.out.println(Arrays.toString(in));
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                q.add(i);
            }
        }
        while(q.size()>0) {
            int front=q.remove();
            ans.add(front);
            for(int ele:adj.get(front)) {
                in[ele]--;
                if (in[ele] == 0) {
                    q.add(ele);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}

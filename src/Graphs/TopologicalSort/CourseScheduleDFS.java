package Graphs.TopologicalSort;

import java.util.ArrayList;

public class CourseScheduleDFS {
    public static void main(String[] args) {
        int[][] pre={{1,4},{2,4},{3,1},{3,2}};    //[1,4],[2,4],[3,1],[3,2]
        System.out.println(canFinish(5,pre));
    }
    public static boolean ans;
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0) return true;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        //adj list initiallisation
        for (int i = 0; i < numCourses; i++) {
            ArrayList<Integer> listt=new ArrayList<>();
            adj.add(listt);
        }
        for (int i = 0; i <prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        System.out.println(adj);
        ans=true;
        boolean[] vis=new boolean[numCourses];
        boolean[] path=new boolean[numCourses];
        for(int i=0;i<numCourses;i++) {
            dfs(vis, path, adj, i);
        }
        return ans;
    }
    public static void dfs(boolean[] vis,boolean[] path,ArrayList<ArrayList<Integer>> adj,int node){
        vis[node]=true;
        path[node]=true;

        for(int ele:adj.get(node)){
            if(path[ele]==true){
                ans=false;  //false means there is a cycle
                return;
            }
            if(vis[ele]==false) dfs(vis,path,adj,ele);
        }
        //last mein path wala box ko uncheck kr rhe (backtrack)
        path[node]=false;
    }
}

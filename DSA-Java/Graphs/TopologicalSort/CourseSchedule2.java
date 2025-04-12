package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2 {
    public static void main(String[] args) {
        int[][] pre={{1,4},{2,4},{3,1},{3,2}};    //[1,4],[2,4],[3,1],[3,2]
        System.out.println(canFinish(5,pre));
    }
    public static int[] canFinish(int numCourses, int[][] prerequisites) {
        //step 1 create a indegree array, adj list,visited arr,ans list
        int[] in=new int[numCourses];
        ArrayList<Integer> ans=new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        //adj list initiallisation
        for (int i = 0; i < numCourses; i++) {
            ArrayList<Integer> listt=new ArrayList<>();
            adj.add(listt);
        }
        Queue<Integer> q=new LinkedList<>();
        //adj list updation and indegree updation
        for (int i = 0; i <prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            in[prerequisites[i][0]]++;
        }
        System.out.println(adj);
        System.out.println(Arrays.toString(in));
        //finding the node which has 0 indegree
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
        System.out.println(ans);
        int[] intArray = ans.stream().mapToInt(Integer::intValue).toArray();
        if(ans.size()!=numCourses) return new int[0];
        else return intArray;
    }
}

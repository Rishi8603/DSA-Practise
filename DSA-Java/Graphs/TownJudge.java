package Graphs;

import java.util.*;

public class TownJudge {
    public static void main(String[] args) {

    }
    public static int findJudge(int n, int[][] trust) {

        // Step 1: indegree and outdegree arrays (1-based indexing)
        int[] indegree  = new int[n + 1];
        int[] outdegree = new int[n + 1];

        // Step 2: fill them in one pass
        for (int[] edge : trust) {
            int u = edge[0];
            int v = edge[1];
            outdegree[u]++;
            indegree [v]++;
        }

        // Step 3: look for someone trusted by everyone else (indegree == n-1)
        //         AND who trusts nobody (outdegree == 0)
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}

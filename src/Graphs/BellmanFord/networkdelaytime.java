package Graphs.BellmanFord;

import java.util.ArrayList;
import java.util.Arrays;

public class networkdelaytime {
    public static void main(String[] args) {
        int[][] time={{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(networkDelayTime(time,4,2));
    }
    public static int networkDelayTime(int[][] times, int n, int src) {
        int[] samay =new int[n+1];
        Arrays.fill(samay,Integer.MAX_VALUE);
        System.out.println(Arrays.toString(samay));
        samay[src]=0;
        for (int j = 0; j < n-1; j++) {
            for (int i = 0; i < times.length; i++) {
                int u=times[i][0];
                int v=times[i][1];
                int wt=times[i][2];
                if (samay[u] != Integer.MAX_VALUE && samay[u]+wt<samay[v]) {
                    samay[v] = samay[u] + wt;
                }
            }
        }
        System.out.println(Arrays.toString(samay));
        int max=Integer.MIN_VALUE;
        for (int i = 1; i < samay.length; i++) {
            if(samay[i]>max) max=samay[i];
        }
        if(max==Integer.MAX_VALUE) return -1;
        else return max;
    }
}

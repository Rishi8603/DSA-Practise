package Graphs.BfsDfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class KeysAndRooms {
    public static void main(String[] args) {
        List<List<Integer>> list = createList();
        System.out.println(list);
        System.out.println(canVisitAllRooms(list));
    }
    public static boolean canVisitAllRooms(List<List<Integer>> rooms){
        boolean[] visited=new boolean[rooms.size()];
        visited[0]=true;
        helper(0,visited,rooms);
        for (int i = 0;i<visited.length ; i++) {
            if(visited[i]==false) return false;
        }
        return true;
    }
    public static void helper(int i,boolean[] visited,List<List<Integer>> rooms){
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        while(q.size()>0) {
            int front=q.remove();
            for (int j = 0; j < rooms.get(front).size(); j++) {
                if(visited[rooms.get(front).get(j)]!=true){
                    int x = rooms.get(front).get(j);
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
    }

    public static List<List<Integer>> createList() {
        List<List<Integer>> list = new ArrayList<>();

        list.add(Arrays.asList(  8));
        list.add(Arrays.asList(5, 4, 9));
        list.add(new ArrayList<>());
        list.add(Arrays.asList(8));
        list.add(Arrays.asList(4));
        list.add(new ArrayList<>());
        list.add(Arrays.asList(1, 9, 2, 3));
        list.add(Arrays.asList(7));
        list.add(Arrays.asList(6, 5));
        list.add(Arrays.asList(2, 3, 1));

        return list;
    }
}

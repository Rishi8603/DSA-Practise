package Backtracking;
import java.util.*;

public class GfgRatInMaze {
    public static void main(String[] args) {
        int[][] mat = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        // Storing the matrix in an ArrayList of ArrayLists
        for (int i = 0; i < mat.length; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < mat[i].length; j++) {
                row.add(mat[i][j]);
            }
            arrayList.add(row);
        }
        System.out.println(findPath(arrayList));
    }
    public static ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        int rows = mat.size();
        int cols = mat.get(0).size();
        boolean[][] isVis=new boolean[rows][cols];
        ArrayList<String> ans=new ArrayList<>();
        helper(mat,0,0,rows-1,cols-1,"",isVis,ans);
        return ans;
    }
    public static void helper(ArrayList<ArrayList<Integer>> mat,int sr, int sc, int er, int ec, String s, boolean[][] isVisited, ArrayList<String> ans) {
        if (sr < 0 || sc < 0 || sr > er || sc > ec) return;
        if (sr == er && sc == ec) {
//            System.out.println(s);
            ans.add(s);
            return;
        }
        if (mat.get(sr).get(sc) == 0 || isVisited[sr][sc]) return; //v important

        isVisited[sr][sc] = true;
        //go down
        helper(mat, sr + 1, sc, er, ec, s + "D", isVisited, ans);
        //go left
        helper(mat, sr, sc - 1, er, ec, s + "L", isVisited, ans);
        //go right
        helper(mat, sr, sc + 1, er, ec, s + "R", isVisited, ans);
        //go up
        helper(mat, sr - 1, sc, er, ec, s + "U", isVisited, ans);
        //BACKTRACKING
        isVisited[sr][sc] = false; //v imp
    }
}

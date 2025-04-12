package Graphs.BfsDfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    static class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '0', '1', '1', '0','1','1'}
        };
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid){
        int rows= grid.length;
        int cols=grid[0].length;
        int count=0;
        boolean[][] visited=new boolean[rows][cols];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (visited[i][j] == false && grid[i][j]=='1') {
                    bfs(visited, grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void bfs(boolean[][] visited,char[][] grid,int i,int j){
        int m=grid.length; int n=grid[0].length;
        visited[i][j]=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,j));
        while(!q.isEmpty()){
            Pair front=q.remove()   ;
            int row = front.row;
            int col = front.col;
            System.out.println(row +","+ col);
            //up
            if(row>0){
                if(grid[row-1][col]=='1' && visited[row-1][col]==false){
                    q.add(new Pair(row-1,col));
                    visited[row-1][col]=true;
                }
            }
            //left
            if(col>0){
                if(grid[row][col-1]=='1' && visited[row][col-1]==false){
                    q.add(new Pair(row,col-1));
                    visited[row][col-1]=true;
                }
            }

            //down
            if((row+1)<m){
                if(grid[row +1][col]=='1' && visited[row +1][col]==false){
                    q.add(new Pair(row +1, col));
                    visited[row +1][col]=true;
                }
            }

            //right
            if((col+1)<n){
                if(visited[row][col+1]==false && grid[row][col+1]=='1'){
                    q.add(new Pair(row,col+1));
                    visited[row][col+1]=true;
                }
            }
        }
    }
}

package Practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class problem0 {
    static class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());// Number of digits
            int m = Integer.parseInt(br.readLine());
            int hand = Integer.parseInt(br.readLine());
//            char[][] a = new char[n];

//            String[] input = br.readLine().split(" ");
//            for (int i = 0; i < n; i++) {
//                for(int j=0;j<m;j++ ) {
//                    a[i] =  // Read the digits
//                }
//            }

//            System.out.println(fxn(a, hand)); // Ensure function output is printed
        }
//        char[][] a = {
//                {'X', 'X', '#', 'X'},
//                {'#', 'X', 'X', '#'},
//                {'#', 'X', '#', 'X'}
//        };
//        System.out.println(fxn(a,10,1));
    }
    static int count=0;
    public static int fxn(char[][] grid,int hand) {
        int rows= grid.length;
        int cols=grid[0].length;
        boolean[][] visited=new boolean[rows][cols];
        for (int i = 0; i < grid.length; i++) {
            if (visited[0][i] == false && grid[0][i]=='X') {
                bfs(visited, grid, 0,i,hand);
            }
        }
        return count;
    }
    public static void bfs(boolean[][] visited,char[][] grid,int i,int j,int hand){
        int m=grid.length; int n=grid[0].length;
        visited[i][j]=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,j));
        while(!q.isEmpty()){
            Pair front=q.remove()   ;
            int row = front.row;
            int col = front.col;
            if(row==m-1) {
                count++;
                return;
            }
//            System.out.println(row +","+ col);
            //left
            if(col>0){
                int a=row;
                int b=col-1;
                int x=Math.abs(row-a);
                int y=Math.abs(col-b);
                int rch=x*x+y*y;
                if(rch>=hand*hand && grid[row][col-1]=='X' && visited[row][col-1]==false){
                    q.add(new Pair(row,col-1));
                    visited[row][col-1]=true;
                }
            }

            //down
            if((row+1)<m){
                int a=row+1;
                int b=col;
                int x=Math.abs(row-a);
                int y=Math.abs(col-b);
                int rch=x*x+y*y;
                if(rch>=hand*hand &&grid[row +1][col]=='X' && visited[row +1][col]==false){
                    q.add(new Pair(row +1, col));
                    visited[row +1][col]=true;
                }
            }

            //right
            if((col+1)<n){
                int a=row;
                int b=col+1;
                int x=Math.abs(row-a);
                int y=Math.abs(col-b);
                int rch=x*x+y*y;
                if(rch>=hand*hand && visited[row][col+1]==false && grid[row][col+1]=='X'){
                    q.add(new Pair(row,col+1));
                    visited[row][col+1]=true;
                }
            }
        }
    }
}
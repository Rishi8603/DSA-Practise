package Backtracking;

import java.util.ArrayList;
import java.util.*;

public class NqueensLeetcode {
    public static void main(String[] args) {
        int n=4;
        System.out.println(solveNQueens(n));
    }
    public static List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<board.length;i++){
            for (int j = 0; j < board[i].length; j++) {
                board[i][j]='.';
            }
        }
        List<List<String>> ans=new ArrayList<>();
        nqueen(board,0,ans);
        return ans;
    }
    public static void nqueen(char[][] board,int row,List<List<String>> ans){
        int n=board.length;
        //base case
        if(row==n){
            display(board,ans);
            return;
        }
        //main code
        for(int j=0;j<n;j++){
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                nqueen(board,row+1,ans);

                board[row][j]='.'; //backtrack
            }
        }
    }
    public static boolean isSafe(char[][] board,int row,int col){
        int n=board.length;
        //check row
        for(int j=0;j<n;j++){
            if(board[row][j]=='Q') return false;
        }
        //check col
        for(int i = 0; i <n; i++){
            if(board[i][col]=='Q') return false;
        }

        //check north east
        int i=row;
        int j=col;
        while(i>=0&&j<n){
            if(board[i][j]=='Q') return false;
            i--;j++;
        }
        //check south east
        i=row;
        j=col;
        while(i<n  && j<n){
            if(board[i][j]=='Q') return false;
            i++;j++;
        }
        //check south west
        i=row;
        j=col;
        while(i<n && j>=0){
            if(board[i][j]=='Q') return false;
            i++;j--;
        }
        //check north west
        i=row;
        j=col;
        while(i>=0 && j>=0){
            if(board[i][j]=='Q') return false;
            i--;j--;
        }
        return true;
    }
    public static void display(char[][] board,List<List<String>> ans){
        List<String> l=new ArrayList<>();
        for(int i=-0;i<board.length;i++){
            String s="";
            for (int j = 0; j < board[i].length; j++) {
                s = s + board[i][j];
            }
            l.add(s);
        }
        ans.add(l);
    }
}

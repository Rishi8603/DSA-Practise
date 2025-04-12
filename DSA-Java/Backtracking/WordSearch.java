package Backtracking;

import javax.swing.*;

public class WordSearch {
    static boolean check=false;
    public static void main(String[] args) {
        char[][] board = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };
        System.out.println(exist(board,"AAB"));
    }
    public static boolean exist(char[][] board, String word) {
        boolean[][] isvalid=new boolean[board.length][board[0].length];
        check=false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char ch=word.charAt(0);
                if(board[i][j]==ch){
                    helper(board,i,j,word,1,isvalid);
                    isvalid[i][j]=false;
                    if(check==true) {
                        return check;
                    }
                }
            }
        }
        return check;
    }

    public static void helper(char[][] board,int row,int col,String word,int pos,boolean[][] isvalid) {

        isvalid[row][col]=true;
        int n = board.length;
        int m=board[0].length;
        //base case
        if (pos == word.length()) {
            check=true;
            return;
        }

        char ch=word.charAt(pos);
        //we will check left,up,right,down
        //check left
        int i=row;
        int j=col-1;
        if(j>=0 && board[i][j]==ch && isvalid[i][j]==false){
            helper(board,i,j,word,pos+1,isvalid);
            if(check) return;
            isvalid[i][j]=false;
        }
        //check up
        i=row-1;
        j=col;
        if(i>=0 && board[i][j]==ch && isvalid[i][j]==false){
            helper(board,i,j,word,pos+1,isvalid);
            if(check) return;
            isvalid[i][j]=false;
        }
        //check right
        i=row;
        j=col+1;
        if(j<m && board[i][j]==ch && isvalid[i][j]==false){
            helper(board,i,j,word,pos+1,isvalid);
            if(check) return;
            isvalid[i][j]=false;
        }
        //check down
        i=row+1;
        j=col;
        if(i<n && board[i][j]==ch && isvalid[i][j]==false){
            helper(board,i,j,word,pos+1,isvalid);
            if(check) return;
            isvalid[i][j]=false;
        }
    }
}

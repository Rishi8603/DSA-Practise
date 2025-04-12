package Backtracking;

import static Backtracking.Nqueens.display;

public class MaxKnightPlacement {
    static int maxKnight=-1;
//    static int number=10;//if we want exactly 3 knight
    public static void main(String[] args) {
        int n=5;
        char[][] board=new char[n][n];
        for(int i=0;i<board.length;i++){
            for (int j = 0; j < board[i].length; j++) {
                board[i][j]='X';
            }
        }

        nknight(board,0,0,0);
        System.out.println(maxKnight);
    }
    //see its optimal approach in notion notes O(1) approach hei bc
    public static void nknight(char[][] board,int row,int col,int num){
        int n=board.length;
        //base case
        if(row==n){
//            if(number==num) {
//                display(board);
//                System.out.println();
//            }
            maxKnight=Math.max(maxKnight,num);
            return;
        }
        else if(isSafe(board,row,col)) {
            board[row][col]='K';
            if(col!=n-1) nknight(board,row,col+1,num+1);
            else nknight(board,row+1,0,num+1);

            board[row][col]='X'; //backtrack
        }
        if(col!=n-1) nknight(board,row,col+1,num);
        else nknight(board,row+1,0,num);
    }
    public static void display(char[][] board){
        for(int i=-0;i<board.length;i++){
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public static boolean isSafe(char[][] grid,int row, int col){
        int n=grid.length;

        //8 case check
        int i,j;
        //2up 1 right
        i=row-2;j=col+1;
        if(i>=0 && j<n && grid[i][j]=='K') return false;

        //2up 1 left
        i=row-2;j=col-1;
        if(i>=0 && j>=0 && grid[i][j]=='K') return false;

        //2 down 1 left
        i=row+2;j=col-1;
        if(i<n && j>=0 && grid[i][j]=='K') return false;

        //2 down 1 right
        i=row+2;j=col+1;
        if(i<n && j<n && grid[i][j]=='K') return false;

        //2 left 1 up
        i=row-1;j=col-2;
        if(i>=0 && j>=0 && grid[i][j]=='K') return false;

        //2 left 1 down
        i=row+1;j=col-2;
        if(i<n && j>=0 && grid[i][j]=='K') return false;

        //2 right 1 up
        i=row-1;j=col+2;
        if(i>=0 && j<n && grid[i][j]=='K') return false;

        //2 right 1 down
        i=row+1;j=col+2;
        if(i<n && j<n && grid[i][j]=='K') return false;

        return true;
    }
}

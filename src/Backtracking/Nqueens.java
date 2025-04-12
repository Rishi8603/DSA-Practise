package Backtracking;

public class Nqueens {
    public static void main(String[] args) {
        int n=4;
        char[][] board=new char[n][n];
        for(int i=0;i<board.length;i++){
            for (int j = 0; j < board[i].length; j++) {
                board[i][j]='X';
            }
        }
        nqueen(board,0);
    }
    public static void nqueen(char[][] board,int row){
        int n=board.length;
        //base case
        if(row==n){
            display(board);
            System.out.println();
            return;
        }
        //main code
        for(int j=0;j<n;j++){
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                nqueen(board,row+1);

                board[row][j]='X'; //backtrack
            }
        }
    }
    public static boolean isSafe(char[][] board,int row,int col){
        int n=board.length;
        //check row -> east and west
        for(int j=0;j<n;j++){
            if(board[row][j]=='Q') return false;
        }
        //check col -> north ans south
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
    public static void display(char[][] board){
        for(int i=-0;i<board.length;i++){
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}

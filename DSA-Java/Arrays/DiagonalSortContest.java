package Arrays;

public class DiagonalSortContest {
    public static void main(String[] args) {
        int[][] matrix = {
                {8, 7, 8, 6, 4},
                {6, 4, 4, 2, 5},
                {1, 7, 4, 6, 4},
                {6, 6, 8, 4, 1},
                {5, 7, 3, 9, 8}
        };
        sortMatrix(matrix);
        System.out.println("{");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("  {");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (j < matrix[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("},");
        }
        System.out.println("};");
    }
    public static int[][] sortMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        //diagonal sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (grid[j][j] < grid[j+1][j + 1]) {  // Swap for descending order
                    int temp = grid[j][j];
                    grid[j][j] = grid[j+1][j + 1];
                    grid[j+1][j + 1] = temp;
                }
            }
        }
        //left sort
        int rowS =1;
        while(rowS <n-1){
            for (int i = rowS; i < n-1; i++) {
                int row=rowS;
                for (int j = 0; j < n-i-1; j++) {
                    //sort
                    if(grid[row][j]<grid[row+1][j+1]){
                        int temp = grid[row][j];
                        grid[row][j] = grid[row+1][j+1];
                        grid[row+1][j+1] = temp;
                    }
                    row++;
                }
            }
            rowS++;
        }
        //right sort
        int colS =1;
        while(colS <m-1){
            for (int i = colS; i < m-1; i++) {
                int col=colS;
                for (int j = 0; j < m-i-1; j++) {
                    if (grid[j][col] > grid[j + 1][col+1]) {
                        int temp = grid[j][col];
                        grid[j][col] = grid[j + 1][col+1];
                        grid[j + 1][col+1] = temp;
                    }
                    col++;
                }
            }
            colS++;
        }
        return grid;
    }
}

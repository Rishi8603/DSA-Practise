package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.List;

public class SortMatrixDiagonal {
    public static void main(String[] args) {
    int[][] matrix = {
            {8, 7, 8, 6, 4,9},
            {6, 4, 4, 2, 5,0},
            {1, 7, 4, 6, 4,3},
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
        int n = grid.length;
        int m=grid[0].length;
        // Sort the bottom-left triangle diagonals (non-increasing order)
        for (int d = 0; d < n; d++) {
            List<Integer> diagonal = new ArrayList<>();
            for (int i = d, j = 0; i < n && j < m; i++, j++) {
                diagonal.add(grid[i][j]);
            }
            Collections.sort(diagonal);
            int index = 0;
            for (int i = d, j = 0; i < n && j < m; i++, j++) {
                grid[i][j] = diagonal.get(index++);
            }
        }
        for (int d = 1; d < m; d++) {
            List<Integer> list=new ArrayList<>();
            for (int i = 0,j=d; i <n && j<m ; i++,j++) {
                list.add(grid[i][j]);
            }
            Collections.sort(list);
            System.out.println(list);
            int idx=0;
            for (int i = 0,j=d; i <n && j<m ; i++,j++) {
                grid[i][j]=list.get(idx);
                idx++;
            }
        }
        return grid;
    }
}

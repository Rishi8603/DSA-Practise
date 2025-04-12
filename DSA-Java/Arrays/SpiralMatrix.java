package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {7},{9},{6}
        };
        System.out.println(spiralOrder(matrix));  // Output: [1,2,3,6,9,8,7,4,5]
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rows = 0, cols = -1;
        int right = matrix[rows].length;
        int down = matrix.length;
        int left = 0;
        int up = rows;

        while (left < right && up < down) { // Fix: Changed OR (||) to AND (&&)
            for (cols = cols+1; cols < right; cols++) {
                System.out.print(matrix[rows][cols]+" ");
                list.add(matrix[rows][cols]);
            }
            cols--;
            right--;
            for (rows = rows+1; rows < down; rows++) {
                System.out.print(matrix[rows][cols]+" ");
                list.add(matrix[rows][cols]);
            }
            rows--;
            down--;
            if(up<=down) {
                for (cols = cols - 1; cols >= left; cols--) {
                    System.out.print(matrix[rows][cols] + " ");
                    list.add(matrix[rows][cols]);
                }
                cols++;
                left++;
            }
            if(left<=right) {
                for (rows = rows - 1; rows > up; rows--) {
                    System.out.print(matrix[rows][cols] + " ");
                    list.add(matrix[rows][cols]);
                }
                rows++;
                up++;
            }
        }
        return list;
    }
}


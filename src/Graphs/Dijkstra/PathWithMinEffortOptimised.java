package Graphs.Dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinEffortOptimised {
    static class Cell {
        int row, col, effort;

        Cell(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }

        @Override
        public String toString() {
            return "(" + row + ", " + col + ")" + "->" + effort + ")";
        }
    }

    public static void main(String[] args) {
        int[][] height = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}};
        System.out.println(minimumEffortPath(height));
    }
//method 2
    public static int minimumEffortPath(int[][] heights) {
        int[][] effortArr = new int[heights.length][heights[0].length];
        for (int[] row : effortArr) {
            Arrays.fill(row, Integer.MAX_VALUE);  // Fill each row with 5
        }
        effortArr[0][0] = 0;
        System.out.println(Arrays.deepToString(effortArr));
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.effort, b.effort));
        pq.add(new Cell(0, 0, 0));
        while (pq.size() > 0) {
            Cell top = pq.remove();
            int rowww = top.row;
            int colll = top.col;
            int eff = top.effort;
            //right
            if (colll < heights[0].length - 1) {
                int CurEffort = Math.abs(heights[rowww][colll] - heights[rowww][colll + 1]);
                int minEffort = Math.max(top.effort, CurEffort);
                if (minEffort < effortArr[rowww][colll + 1]) {
                    effortArr[rowww][colll + 1] = minEffort;
                    pq.add(new Cell(rowww, colll + 1, minEffort));
                }
            }
            //down
            if (rowww < heights.length - 1) {
                int CurEffort = Math.abs(heights[rowww][colll] - heights[rowww + 1][colll]);
                int minEffort = Math.max(top.effort, CurEffort);
                if (minEffort < effortArr[rowww + 1][colll]) {
                    effortArr[rowww + 1][colll] = minEffort;
                    pq.add(new Cell(rowww + 1, colll, minEffort));
                }
            }
            //left
            if (colll > 0) {
                int CurEffort = Math.abs(heights[rowww][colll] - heights[rowww][colll - 1]);
                int minEffort = Math.max(top.effort, CurEffort);
                if (minEffort < effortArr[rowww][colll - 1]) {
                    effortArr[rowww][colll - 1] = minEffort;
                    pq.add(new Cell(rowww, colll - 1, minEffort));
                }
            }
            //up
            if (rowww > 0) {
                int CurEffort = Math.abs(heights[rowww][colll] - heights[rowww - 1][colll]);
                int minEffort = Math.max(top.effort, CurEffort);
                if (minEffort < effortArr[rowww - 1][colll]) {
                    effortArr[rowww - 1][colll] = minEffort;
                    pq.add(new Cell(rowww - 1, colll, minEffort));
                }
            }
        }
        System.out.println(Arrays.deepToString(effortArr));
        return effortArr[heights.length - 1][heights[0].length - 1];
    }
}
    //method 3 gpt

//    public int minimumEffortPath(int[][] heights) {
//        int n = heights.length, m = heights[0].length;
//        int[][] effortArr = new int[n][m];
//        for (int[] row : effortArr) Arrays.fill(row, Integer.MAX_VALUE);
//        effortArr[0][0] = 0;
//
//        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.effort, b.effort));
//        pq.add(new Cell(0, 0, 0));
//
//        int[] dx = {0, 1, 0, -1};  // Right, Down, Left, Up
//        int[] dy = {1, 0, -1, 0};
//
//        while (!pq.isEmpty()) {
//            Cell top = pq.poll();
//            int row = top.row, col = top.col, eff = top.effort;
//
//            // If we've reached the bottom-right cell, return the effort
//            if (row == n - 1 && col == m - 1) return eff;
//
//            for (int i = 0; i < 4; i++) {
//                int newRow = row + dx[i], newCol = col + dy[i];
//
//                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
//                    int newEffort = Math.max(eff, Math.abs(heights[row][col] - heights[newRow][newCol]));
//
//                    if (newEffort < effortArr[newRow][newCol]) {
//                        effortArr[newRow][newCol] = newEffort;
//                        pq.add(new Cell(newRow, newCol, newEffort));
//                    }
//                }
//            }
//        }
//        return 0;  // Should never reach here
//    }

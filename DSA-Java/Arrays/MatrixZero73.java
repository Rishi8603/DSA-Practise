package Arrays;

import java.util.Arrays;

public class MatrixZero73 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,0,5},{6,1,7,8,0},{7,0,6,5,8},{0,2,3,6,7},{1,8,0,9,8}};
        setZeroes(arr);
        System.out.println(Arrays.deepToString(arr)); // Output the modified matrix
    }

    public static void setZeroes(int[][] matrix) {
        //total 5 step hei
        //pehla step mein tha ki check first row and col is zero or not........
        // dsra  step mein tha ki traverse across each rows
        // and if there is zero mark the first element of that row to zero and mark that columns first element to be zero.....
        //3rd step is to set respective rows & cols to 0
        //4th step is to make 0 first row if needed
        //5th step is to make 0 first col if needed
    }
}

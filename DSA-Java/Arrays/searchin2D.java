package Arrays;

public class searchin2D {
    public static boolean search(int[][] matrix, int target){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col]==target){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] arr={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target=5;
        System.out.println(search(arr,target));
    }
}

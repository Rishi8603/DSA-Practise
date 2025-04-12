package Arrays;

public class Minsearchin2d {
    public static void main(String[] args) {
        int[][] arr={
            {-55, 2, 3},
            {556, 6, 4, 46},
            {545,54,5,5}
        };
//        int target=99;
        int search = min(arr);
        System.out.println(search);
    }

    static int min(int[][] arr){
        int ans=Integer.MAX_VALUE;
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if(arr[row][col]<ans){
                    ans=arr[row][col];
                }
            }

        }
        return ans;
    }
}

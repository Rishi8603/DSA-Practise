package BinarySearch;

public class searchinrange {
    public static void main(String[] args) {
        int[] arr={11,22,54,9,5,44,7,3,4};

        int start=2;
        int end=7;
        int ans=search(arr,3,2,7);
        System.out.println(ans);
    }
    static int search(int[] arr,int target,int start,int end){

        while(start<=end){
            if(arr[start]==target){
                return start;
            }
           start++;
        }
            return -1;
    }
}

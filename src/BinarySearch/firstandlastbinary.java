package BinarySearch;

public class firstandlastbinary {
    public static void main(String[] args) {
        int[] arr = {5,7,7,7,7,8,8,10};
        int target = 7;
        int jhc=ceilingarr(arr,target);
        System.out.println(arr[jhc]);
    }
    static int ceilingarr(int[] arr,int target) {
        int[] answ = {-1, -1};
        int start = 0;
        int end = arr.length - 1;


        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else if (target == arr[mid]) {

            }
        }
            return start;
    }

}
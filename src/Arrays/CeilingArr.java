package Arrays;

public class CeilingArr {
    public static void main(String[] args) {
        int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        int target = 90;
        int jhc=ceilingarr(arr,target);
        System.out.println(arr[jhc]);
    }
    static int ceilingarr(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        int ans=0;

        while(start<=end) {
            int mid=start+(end-start)/2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else if (target == arr[mid]) {
                ans = mid;
                return ans;
            }
        }
//        if(target!=mid){
//            return
//        }
        return start;
    }
}

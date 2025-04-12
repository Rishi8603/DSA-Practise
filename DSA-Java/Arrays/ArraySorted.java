package Arrays;

public class ArraySorted {
    public static void main(String[] args) {
        int[] arr={3,4,5,1,2};
        System.out.println(check(arr));
    }
    public static boolean check(int[] nums){
    //add two numbers


        int left=0;
        int right=nums.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[left]<nums[mid]){
                //left is sorted
                left=mid+1;
            }
        }
        return false;
    }
}

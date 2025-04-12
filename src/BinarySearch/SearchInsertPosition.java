package BinarySearch;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        int target=4;
        System.out.println(searchInsert(nums,target));
    }
    public static int searchInsert(int[] nums, int target){
        int s=0;
        int e=nums.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(target<nums[m]){
                e=m-1;
            }else if(target>nums[m]){
                s=m+1;
            }else{
                return m;
            }
        }
        if(s>e){
            return s;
        }
        return -1;
    }
}

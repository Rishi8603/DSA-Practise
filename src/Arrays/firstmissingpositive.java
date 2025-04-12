package Arrays;

public class firstmissingpositive {
    public static void main(String[] args) {
        int[] nums={5,4,3,2,1};
        int ans=missing(nums);
        System.out.println(ans);
    }
    static int missing(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctindex = nums[i] - 1;
            if (nums[i]<nums.length && nums[i]>0 && nums[i] != nums[correctindex]) {
                swap(i, correctindex, nums);
            } else {
                i++;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                return index+1;
            }
        }
       return nums.length+1;
    }
    static void swap(int first,int second,int[] arr){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;

    }
}

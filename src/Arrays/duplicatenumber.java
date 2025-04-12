package Arrays;

public class duplicatenumber {
    public static void main(String[] args) {
        int[] nums={3,3,3,3,3};
        int ans=sort(nums);
        System.out.println(ans);
    }
    static int sort(int[] nums){
        int i=0;
        while(i<nums.length){
            int correctindex=nums[i]-1;
            if (nums[i]!=nums[correctindex]) {
                swap(i,correctindex,nums);
            }else{
                i++;
            }
        }

        //search missing number
        for(int index=0;index<nums.length;index++){
            if(nums[index]!=index+1) {
                return nums[index];
            }
        }
        return -1;
    }
    static void swap(int first,int second,int[] arr){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;

    }
}

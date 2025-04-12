package Arrays;

public class missingnumber {
    public static void main(String[] args) {
        int[] arr={0,1};
        int ans=sort(arr);
        System.out.println(ans);
    }
    static int sort(int[] nums){
        int i=0;
        while(i< nums.length){
            int correctindex= nums[i];
            if (nums[i]< nums.length && i!= nums[i]) {
                swap(i,correctindex, nums);
            }else{
                i++;
            }
        }

        //search missing number
        for(int index = 0; index< nums.length; index++){
            if(nums[index]!=index) {
                return index;
            }
        }
        return nums.length;
    }

    static void swap(int first,int second,int[] arr){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}

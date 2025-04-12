package Arrays;

public class RemoveElements {
    public static void main(String[] args) {
        int[] arr = {3,3};
        System.out.println(removeElement(arr,5));
    }
    public static int removeElement(int[] nums, int val) {
        if(nums.length==0) return 0;
        if(nums.length==1){
            if(nums[0]==val) return 0;
            else return 1;
        }
        int ui=nums.length-1;
        int i=nums.length-2;
        while(i>=0){
            if(nums[i]==val){
                if(nums[ui]==val){
                    ui--;
                }
                int temp=nums[ui];
                nums[ui]=nums[i];
                nums[i]=temp;
                i--;
            }else{
                i--;
            }
        }
        if(nums[ui]!=val) return ui+1;
        else return ui;
    }
}

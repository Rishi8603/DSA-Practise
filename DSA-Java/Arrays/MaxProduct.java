package Arrays;

public class MaxProduct {
    public static void main(String[] args) {
        int[] nums={2,-5,-2,-4,3};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        int maxSofar=nums[0];
        int minSofar=nums[0];
        int result=nums[0];
        int temp;int t1;int t2;
        for(int i=1;i<nums.length;i++){
            int curr=nums[i];
            temp=maxSofar;
            t1=Math.max(curr,curr*maxSofar);
            maxSofar=Math.max(t1,curr*minSofar);
            t2=Math.min(curr,curr*temp);
            minSofar=Math.min(t2,curr*minSofar);
            result=Math.max(result,maxSofar);
        }
        return result;
    }
}

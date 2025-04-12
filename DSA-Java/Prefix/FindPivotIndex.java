package Prefix;

public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums={-1,-1,-1,-1,-1,0};
        System.out.println(pivotIndex(nums));
    }
    public static int pivotIndex(int[] nums) {
        int n=nums.length;

        int[] pre=new int[n];
//        int[] suf=new int[n];
//        int j=n-2;
        pre[0]=nums[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+nums[i];
//            suf[j]=suf[j+1]+nums[j];
//            j--;
        }
        int leftSum=0;int rightSum=0;
        for(int i=0;i<n;i++){
            leftSum=pre[i]-nums[i];
            rightSum=pre[n-1]-pre[i];
            if(leftSum==rightSum) return i;
        }
//        for(int i=0;i<n;i++){
//            if(pre[i]==suf[i]){
//                return i;
//            }
//        }
        return -1;
    }
}

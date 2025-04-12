package DP.Knapsack01;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] nums={1,5,11,5};
        System.out.println(canPartition(nums));
    }
    public static boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
        if(sum%2!=0) return false;
        else{//agr ek subset mil gya jiska sum = sum/2 than there will be another subset also...as total sum is even
            return isSubsetSum(nums,sum/2);
        }
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        int n=arr.length;
        // similar to 01 knapsack we will use bottom-up approach
        boolean[][] t=new boolean[n+1][sum+1];
        //so first we'll do initiallisation
        for(int i=0;i<n+1;i++){
            for(int j=0;j<t[0].length;j++){
                if(i==0){
                    t[i][j]=false;
                }
                if(j==0){
                    t[i][j]=true;
                }
            }
        }
        //main code
        for(int i=1;i<n+1;i++){
            for(int j=1;j<t[0].length;j++){
                if(arr[i-1]<=j){//connecting dots-->MAX changes to OR here and also as VAL[] is not given so ignore it
                    t[i][j]=t[i-1][j-arr[i-1]] || t[i-1][j];
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}

package DP.Knapsack01;

public class CountOfSubsetSumWithGivenSum {
    public static void main(String[] args) {
        int[] arr={0,1};
        System.out.println(isSubsetSum(arr,1));
    }
    static int isSubsetSum(int arr[], int sum) {
        int n=arr.length;
        // similar to 01 knapsack we will use bottom-up approach
        int[][] t=new int[n+1][sum+1];
        //so first we'll do initiallisation
        t[0][0]=1;
        int cnt=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                cnt=cnt*2;
                t[i+1][0]=cnt;
            }else{
                t[i+1][0]=t[i][0];
            }
        }
        //main code
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){//connecting dots-->MAX changes to OR here and also as VAL[] is not given so ignore it
                    t[i][j]=t[i-1][j-arr[i-1]] + t[i-1][j];
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}

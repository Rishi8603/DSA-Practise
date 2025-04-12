package DP.Knapsack01;

public class CountOfSubsetSumWithgivenDiff {
    public static void main(String[] args) {
        int[] arr={1,3,3,2,1};
        int d=5;
        System.out.println(countPartitions(arr,d));
    }
    static int countPartitions(int[] arr, int d) {
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
        }
        int s1=(sum+d)/2;
        return isSubsetSum(arr,s1);
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
                if(arr[i-1]<=j){
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

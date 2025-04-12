package Prefix;
import java.util.*;
public class LongestSubsequenceWithLimitedSum {
    public static void main(String[] args) {
        int[] nums={1,2,4,5};
        int[] queries={3,10,21};
        System.out.println(Arrays.toString(answerQueries(nums,queries)));
    }
    public static int[] answerQueries(int[] nums, int[] queries) {
        int n=nums.length;
        Arrays.sort(nums);
        // int[] pre=new int[n];
        for(int i=1;i<n;i++){
            nums[i]=nums[i]+nums[i-1];
        }
        for(int j=0;j<queries.length;j++){
            int start=0;int end=n-1;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(nums[mid]==queries[j]){
                    queries[j]=mid+1;
                    break;
                }else if(queries[j]>nums[mid]){//search in right
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
            if(start>end){
                queries[j]=end+1;
                // if(i==n && queries[j]>nums[i-1]) queries[j]=n;
                // else if(nums[i]!=queries[j]) queries[j]=i;
                // else queries[j]=i+1;
            }
        }
        return queries;
    }
}

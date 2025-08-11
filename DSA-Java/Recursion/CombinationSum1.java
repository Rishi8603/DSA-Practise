package Recursion;
import java.util.*;
public class CombinationSum1 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(combinationSum(nums,7));
    }
    static List<List<Integer>> ans;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        helper(candidates,target,0,0,list);
        
        return ans;
    }

    public static void helper(int[] candidates,int target,int sum,int i,List<Integer> list) {
        //base case
        if(sum==target){
            List<Integer> d=new ArrayList<>(list);
            ans.add(d);
            return;
        }
        if(target>sum){
            sum=sum+candidates[i];
            list.add(candidates[i]);
            helper(candidates,target,sum,i,list);
        }else{
            sum=sum-candidates[i];
            i++;
            sum=sum+candidates[i];
            list.remove(list.size()-1);
            list.add(candidates[i]);
            helper(candidates,target,sum,i,list);
        }
    }
}

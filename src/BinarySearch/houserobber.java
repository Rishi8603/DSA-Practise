package BinarySearch;

public class houserobber {
    public static void main(String[] args) {
        int[] nums = {2,1,1,2};
        int ans = amount(nums);
        System.out.println(ans);
    }
    static int amount(int[] nums){
        int case1=0;
        int case2=0;
        for(int i=0;i< nums.length;i++){
            if(i%2!=0){
                case1=case1+nums[i];
            }else{
                case2=case2+nums[i];
            }
        }
        return check(case1,case2);
    }
    static int check(int a,int b){
        if(a>=b){
            return a;
        }else{
            return b;
        }
    }
}

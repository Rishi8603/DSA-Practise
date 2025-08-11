package LeetcodeDaily;
import java.util.*;

public class RangeProdQueriesPower2438 {
    public static void main(String[] args) {
        int[][] arr1 = { {0,0}};
        System.out.println(Arrays.toString(productQueries(2,arr1)));
    }
    static final int MOD=1000000007;
    public static int[] productQueries(int n, int[][] queries) {
        //power array bnao
        ArrayList<Integer> list = new ArrayList<>();
        int temp=0;int i=0;int x=0;
        while(n!=0){
            x=n&1;
            if(x==1){
                temp= (int)modPower(2,i,MOD);
                list.add(temp);
            }
            n=n>>1;
            i++;
        }

        //prefix product array bnao
        int[] arr=new int[list.size()];
        arr[0]=list.get(0);
        for(int j=1;j<list.size();j++){
            arr[j]=(int)((arr[j-1]*1L*list.get(j)) % MOD);
        }

        //at last answer array bnao
        int[] ans= new int[queries.length];
        for(int k=0;k<queries.length;k++){
            int a=queries[k][0];
            int b=queries[k][1];
            if(a==0){
                ans[k]=arr[b];
            }else {
                long numerator=arr[b];
                long denominator=arr[a-1];
                long inv = modInverse(denominator, MOD);
                ans[k] = (int)((numerator*inv) % MOD);
            }
        }
        return ans;
    }
    static long modPower(long x, long y, long mod) {
        if (y == 0) return 1;  // Base case: x^0 = 1

        long half = modPower(x, y / 2, mod);

        if (y % 2 == 0)
            return (half * half) % mod;  // Directly return for even y
        else
            return (x * (half * half % mod)) % mod;  // Multiply x if y is odd
    }
    private static long modInverse(long a, int mod) {
        return modPower(a, mod - 2, mod);
    }
}

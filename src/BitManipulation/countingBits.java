package BitManipulation;
import java.util.Arrays;
public class countingBits {
    public static void main(String[] args) {
        int n=5;
        System.out.println(Arrays.toString(fun(n)));
    }
    public static int[] fun(int n){
        int[] arr=new int[n+1];
        for (int i = 0; i < arr.length; i++) {
          arr[i]=bitsCount(i);
        }
//        System.out.println(Arrays.toString(arr));
        return arr;
    }
    public static int bitsCount(int val){
        int count=0;
        while(val>0){
            int temp=val;
            int q=temp&1;
            if(q==1) count++;
            val=val>>1;
        }
        return count;
    }
}
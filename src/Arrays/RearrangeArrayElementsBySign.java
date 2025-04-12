package Arrays;

import java.util.Arrays;

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int[] arr = {28, -41, 22, -8, -37, 46, 35, -9, 18, -6, 19, -26, -37, -10, -9, 15, 14, 31};
        System.out.println(Arrays.toString(rearrangeArray(arr)));
    }

    public static int[] rearrangeArray(int[] nums) {
        int[] result=new int[nums.length];
        int pos=0;
        int neg=1;
        for(int num:nums){
            if(num>0){
                result[pos]=num;
                pos+=2;
            }else{
                result[neg]=num;
                neg+=2;
            }
        }
        return result;
    }
}

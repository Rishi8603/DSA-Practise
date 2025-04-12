package Hashing;

import java.util.HashMap;

public class HashingStriver1 {
    public static void main(String[] args) {
        int[] nums={10,5,10,15,10,5};
        System.out.println(check2(nums));
    }
    public static int check2(int[] arr){
        int max=0;
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int num=arr[i];
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        for (int i = 0; i < arr.length; i++) {
            if(freq.containsKey(i)){
                int x=freq.get(i);
                if(max>x){
                    break;
                }else{
                    max=x;
                }
            }else{
                int x=0;
            }

        }
        return max;
    }
}
//static int check(int[] arr){
//        precompute
//        int[] hash=new int[16];
//        for (int i = 0; i < arr.length; i++) {
//            hash[arr[i]]++;
//        }
//        for (int i = 0; i < hash.length; i++) {
//            int max=0;
//            if(arr[i]>max) {
//                max = arr[i];
//                return max;
//            }
//        }
//        return 1;
//    }

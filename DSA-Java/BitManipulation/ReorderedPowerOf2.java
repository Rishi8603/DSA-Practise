package BitManipulation;

import java.util.*;

public class ReorderedPowerOf2 {
    public static void main(String[] args) {
//        System.out.println(reorderedPowerOf2(10));
    }
//    private static boolean computed=false;
//    public static void populateList(){
//        ArrayList<ArrayList<Integer>>
//    }
//    public static boolean reorderedPowerOf2(int n) {
//        if(!computed) {
//            populateList();
//        }
//
//
//    }
//    static boolean check;
//    public static boolean reorderedPowerOf2(int n) {
//        check=false;
//        int size=countDigit(n);
//        int[] arr=new int[size];
//
//        int i=size-1;
//        while(n>0){
//            arr[i]=n%10;
//            n=n/10;
//            i--;
//        }
//        System.out.println(Arrays.toString(arr));
//        permute(arr,0);
//        return check;
//    }
//    public static void permute(int[] arr, int index){
//        if (index == arr.length) {
//            String s="";
//            for (int num : arr) {
//                s=s+num;
//            }
//            if(s.charAt(0)=='0') return;
//            int temp=Integer.parseInt(s);
//            if ((temp & (temp-1)) ==0) check=true;
//            return;
//        }
//
//        for (int i = index; i < arr.length; i++) {
//            if(check) return;
//            else {
//                swap(arr, index, i);
//                permute(arr, index + 1);
//                swap(arr, index, i); // backtrack
//            }
//        }
//    }
//    public static int countDigit(int val){
//        if(val==0){
//            return 0;
//        }
//        return 1+countDigit(val/10);
//    }
//    static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
}

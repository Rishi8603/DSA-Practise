package Practise;

import java.util.*;

public class mainn {
    public static void main(String[] args) {
        HashSet<Character> set=new HashSet<>();
        set.add('a');
        set.add('a');
        set.remove('a');
        System.out.println(set.isEmpty());
       int n=10;
       int[] arr={1,2,3,4};
       fx(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void fx(int[] n){
        n[0]=10;
        System.out.println(Arrays.toString(n));
        return;
    }
    public static String helper(int[] a, int[] bArr) {
        Integer[] b = Arrays.stream(bArr).boxed().toArray(Integer[]::new);
        Arrays.sort(b);  // ascending order
        System.out.println(Arrays.toString(b));
        int l=Integer.MIN_VALUE;
        a[0]=b[0]-a[0];
        l=a[0];
        int x=0;
        for (int i = 1; i < a.length; i++) {
            int tar=a[i]+l;
            if(tar<b[b.length-1]){
                x=binarySearch(tar,b);
                if(x<a[i]){
                    a[i]=x-a[i];
                    l=a[i];
                }
            }
//            else{
//                if(a[i]<b[b.length-1]) a[i]=
//            }
        }

        for (int i = 0; i < a.length-1; i++) {
            if(a[i]>a[i+1]){
                return "NO";
            }
        }
        return "YES";
    }
    public static int binarySearch(int target,Integer[] arr){
        int start=0;
        int end=arr.length-1;
        int ans=-1;
        while(end>=start){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                ans=arr[mid];
                return arr[mid] ;
            }
            else if(arr[mid]<target){
                //search in right
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        if(start>end && start<arr.length-1){
            ans=arr[start];
            return ans;
        }
        else return ans;
    }
}

package Sorting;

import java.util.Arrays;

public class cyclicsort {
    public static void main(String[] args) {
        int[] arr={9,6,4,2,3,5,7,8,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]==arr[correct]){
                i++;
            }else{
                swap(arr,i,correct);
            }
        }
    }
    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}

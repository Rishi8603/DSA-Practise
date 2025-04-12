package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayLeaders {
    public static void main(String[] args) {
        int[] arr={16, 17, 4, 3, 5, 2};
        System.out.println(leaders(arr));
    }
    public static ArrayList<Integer> leaders(int[] arr){
        ArrayList<Integer> list=new ArrayList<>();
        int maxSofar=0;
        for (int i = arr.length-1; i >=0 ; i--) {
            if(list.isEmpty()) {
                list.add(arr[i]);
                maxSofar=arr[i];
            }
            else if(arr[i]>= maxSofar){
                list.add(arr[i]);
                maxSofar=arr[i];
            }
        }

        Collections.reverse(list);
        return list;
    }
}

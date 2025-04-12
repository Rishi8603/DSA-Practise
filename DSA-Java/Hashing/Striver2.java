package Hashing;

import java.util.*;

public class Striver2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        //precompute
        HashMap<Integer,Integer> freqMap=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (freqMap.containsKey(num)) {
                freqMap.put(num, freqMap.get(num) + 1);
            } else {
                freqMap.put(num, 1);
            }
        }
        //Handle Queries
        //kitna number check krna hei wo store hoga q mein
        int q=sc.nextInt();
        while(q>0){
                int queryNum=sc.nextInt();
                if(freqMap.containsKey(queryNum)){
                    System.out.println(freqMap.get(queryNum));
                }else{
                    System.out.println(0);
                }
                q--;
        }
        sc.close();
    }
}


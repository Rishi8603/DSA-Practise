package Greedy;

import java.util.*;

public class MinimumPlatforms {
    static class train{
        int aaya,gya;
        train(int aaya,int gya){
            this.aaya=aaya;
            this.gya=gya;
        }
    }
    static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0,j=0;
        int count=0;
        int maxCount=0;
        while(i<arr.length && j<dep.length){
            if(arr[i]<dep[j]){
                count++;
                i++;
            }else if(arr[i]>dep[j]){
                count--;
                j++;
            }
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
    //bruteforce
//    static int findPlatform(int arr[], int dep[]) {
//        ArrayList<train> list=new ArrayList<>();
//        for(int i=0;i<arr.length;i++){
//            list.add(new train(arr[i],dep[i]));
//        }
//        list.sort((a,b)-> a.aaya-b.aaya);
//        int[] depTimes = new int[arr.length];
//        depTimes[0] = list.get(0).gya;
//        int platformCount = 1;
//        for (int i = 1; i < list.size(); i++) {
//            boolean allocated = false;
//            for (int j = 0; j < platformCount; j++) {
//                if (depTimes[j] < list.get(i).aaya) {
//                    depTimes[j] = list.get(i).gya;
//                    allocated = true;
//                    break;
//                }
//            }
//            if (!allocated){
//                depTimes[platformCount++] = list.get(i).gya;
//            }
//        }
//        return platformCount;
//    }
    public static void main(String[] args) {
        int[] arr={100, 200, 250, 300, 400};
        int[] dep={350, 220, 270, 330, 500};
        System.out.println(findPlatform(arr,dep));
    }
}

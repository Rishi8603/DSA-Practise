package SlidingWindow;

import java.util.HashMap;

public class FruitBasket {
    public static void main(String[] args) {
        int[] fruit={2,3,2,2,4,5,6,7};
        System.out.println(totalFruit(fruit));
    }
    public static int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map=new HashMap<>();
        //3 step hei
        //first step..right pointer wala fruits ko map me add
        //second step..check size of map..if  greater than 2..left ko inc and freq dec
        //third step...find length
        int left=0,len=0,maxlen=0;
        for(int right = 0; right <fruits.length; right++){
           //first step
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            //second step
            while(map.size()>2){
                int freq=map.get(fruits[left]);
                map.put(fruits[left],freq-1 );
                if(map.get(fruits[left])==0) map.remove(fruits[left]);
                left++;
            }
            //third step
            len=right-left+1;
            maxlen=Math.max(len,maxlen);
        }
        return maxlen;
    }
}

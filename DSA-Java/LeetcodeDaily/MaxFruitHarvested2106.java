package LeetcodeDaily;

public class MaxFruitHarvested2106 {
    public static void main(String[] args) {
        int[][] fruit={{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}};
        System.out.println(maxTotalFruits(fruit,5,4));
    }
    public static int maxTotalFruits(int[][] fruits, int startPos, int k) {
        // Edge case: if k is 0, we can only pick fruits at startPos.
        if (k == 0) {
            for (int[] fruit : fruits) {
                if (fruit[0] == startPos) {
                    return fruit[1];
                }
            }
            return 0;
        }

        // Find the maximum position to determine the size of the prefix sum array.
        // The farthest reachable point is startPos + k.
        int maxPosition=startPos+k;
        if(fruits.length>0){
            maxPosition=Math.max(maxPosition,fruits[fruits.length - 1][0]);
        }

        // ## 1. Create the Prefix Sum Array ##
        int[] pre = new int[maxPosition + 1];

        for (int i=0;i<fruits.length;i++) {
            int position = fruits[i][0];
            int amount = fruits[i][1];
            pre[position] = amount;
        }
        for (int i = 1; i <= maxPosition; i++) {
            pre[i] += pre[i - 1];
        }

        // ## 2. Apply the Sliding Window ##
        int maxH=0;
        int left=0;
        for(int right=0;right<=maxPosition;right++){
            int cost=0;
            if(right<startPos){
                //case1:window is entirely to left of startPos
                cost=startPos-left;
            }else if(left>startPos){
                //case2: window is entirely to right of startPos
                cost=right-startPos;
            }else{
                //case3:window spans startPos. calculate the cost of both paths
                //(i.e: going left-first vs right-first) and take the minimum.
                int distLeft=startPos-left;
                int distRight=right-startPos;
                cost=Math.min(2*distLeft+distRight,distLeft+2*distRight);
            }

            //if cost is too high, shrink window from the left until it is valid again
            while(cost>k && left<=right){
                left++;
                if(right<startPos){
                    cost=startPos-left;
                }else if(left>startPos){
                    cost=right-startPos;
                }else{
                    int distLeft = startPos-left;
                    int distRight = right - startPos;
                    cost = Math.min(2 * distLeft + distRight, distLeft + 2 * distRight);
                }
            }
            int currentH;
            if(left>0){
                currentH=pre[right]-pre[left-1];
            }else{
                currentH=pre[right];
            }
            maxH=Math.max(maxH,currentH);
        }

        return maxH;
    }
}

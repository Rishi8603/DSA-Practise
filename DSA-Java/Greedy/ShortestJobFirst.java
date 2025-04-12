package Greedy;
import java.util.*;
public class ShortestJobFirst {
    public static void main(String[] args) {
        int[] bt={1,2,3,4};
        System.out.println(solve(bt));
    }
    static int solve(int bt[] ) {
        Arrays.sort(bt);
        int  wtTime=0;
        int time=0;
        //1 2 3 4 7
        for(int j=0;j<bt.length;j++){
            wtTime=wtTime+time;
            time=time+bt[j];
        }
        return wtTime /bt.length;
    }
}

package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class CountDayswithMeetingLeetcode3169 {
    public static void main(String[] args) {
        int[][] arr={{6,11}, {7,13}, {8,9}, {5,8}, {3,13}, {11,13}, {1,3}, {5,10}, {8,13}, {3,9}};
        System.out.println(countDays(8,arr));
    }
    public static int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)-> a[0]-b[0]);
        System.out.println(Arrays.deepToString(meetings));
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        int start=meetings[0][0];int end=meetings[0][1];
        for(int i=1;i<meetings.length;i++){
            if(end>=meetings[i][0]){
                end=Math.max(meetings[i][1],end);
//                start=Math.min(meetings[i][0],start);
            }else{
                ArrayList<Integer> list=new ArrayList<>();
                list.add(start);
                list.add(end);
                ans.add(list);
                start=meetings[i][0];end=meetings[i][1];
            }
        }
        //add last element
        ArrayList<Integer> list=new ArrayList<>();
        list.add(start);
        list.add(end);
        ans.add(list);
        System.out.println(ans);
        //now we will count number of working days
        int total=0;
        for(int i=0;i<ans.size();i++){
            total=total+ans.get(i).get(1)-ans.get(i).get(0)+1;
        }
        int free=days-total;
        if(free>=0) return free;
        else return 0;
    }
}

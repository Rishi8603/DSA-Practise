package Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class NmeetingInOneRoom {
    static class Meet{
        int sTime,eTime;
        Meet(int sTime,int eTime){
            this.sTime=sTime;
            this.eTime=eTime;
        }
    }
    public static int maxMeetings(int start[], int end[]) {
        ArrayList<Meet> meet=new ArrayList<>();
        for(int i=0;i<start.length;i++){
            meet.add(new Meet(start[i],end[i]));
        }
        meet.sort((a,b)-> (a.eTime-b.eTime));
        int count=0;
        int lastEndTime=-1;
        for (int i = 0; i < meet.size(); i++) {
            if(meet.get(i).sTime>lastEndTime){
                count++;
                lastEndTime=meet.get(i).eTime;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] start={1,3,0,5,8,5};
        int[] end={2,4,6,7,9,9};
        System.out.println(maxMeetings(start,end));
    }
}

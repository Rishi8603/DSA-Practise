package Greedy;

import java.util.*;

public class JobSequencing {
    static class Job{
       int id,deadline,profit;
       Job(int id,int deadline,int profit){
           this.id=id;
           this.deadline=deadline;
           this.profit=profit;
       }
    }
    public static void main(String[] args) {
        int[] id={1,2,3,4,5,6,7,8};
        int[] deadline={4,5,6,6,4,2,2,2};
        int[] profit={20,60,70,65,25,80,10,22};
        System.out.println(JobSequencing(id,deadline,profit));
    }
    public static ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        ArrayList<Job> jobs =new ArrayList<>();
        for(int i=0;i<id.length;i++){
            jobs.add(new Job(id[i],deadline[i],profit[i]));
        }
        //sorting jobs in descending order
        jobs.sort((a,b)-> (b.profit-a.profit));
        int maxD=0;
        for(int num:deadline){
            maxD=Math.max(num,maxD);
        }
        int[] slot =new int[maxD+1];
        Arrays.fill(slot,-1);
        int maxP=0,count=0;
        for (int i = 0; i < jobs.size(); i++) {
            int k= jobs.get(i).deadline;
            while(k>0){
                if(slot[k]==-1) {
                    slot[k] = jobs.get(i).id;
                    count++;
                    maxP = maxP + jobs.get(i).profit;
                    break;
                }else{
                    k--;
                }
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(count);
        ans.add(maxP);
        return ans;
    }
}

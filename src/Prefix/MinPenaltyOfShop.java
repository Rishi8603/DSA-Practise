package Prefix;

public class MinPenaltyOfShop {
    public static void main(String[] args) {
        String str="YYNY";
        System.out.println(bestClosingTime(str));
    }
    public static int bestClosingTime(String str) {
        int n=str.length();
        //dukanKhula & customer nhi aaya--we will fill this value in pre[] ..we will also see 'N' in str if present than inc by 1
        int[] pre=new int[n+1];
        for(int i=1;i<pre.length;i++){
            pre[i]=pre[i-1];
            if(str.charAt(i-1)=='N') pre[i]+=1;
        }
        //dukanBnd & customer aaya ->we will fill this value in suf[]..loop piche se chalana hei,and if 'Y' is there than inc by 1
        int[] suf=new int[n+1];
        for(int i=suf.length-2;i>=0;i--){
            suf[i]=suf[i+1];
            if(str.charAt(i)=='Y') suf[i]+=1;
        }
        //now build penalty array
        int min=Integer.MAX_VALUE;
        int[] penalty=new int[n+1];
        for(int i=0;i<pre.length;i++){
            penalty[i]=pre[i]+suf[i];
            min=Math.min(min,penalty[i]);
        }
        //now if penalty is same, return the min hour of which shop is open
        for(int i=0;i<penalty.length;i++){
            if(min==penalty[i]) return i;
        }
        return -1;
    }
}

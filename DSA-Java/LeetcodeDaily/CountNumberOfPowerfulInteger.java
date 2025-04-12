package LeetcodeDaily;

public class CountNumberOfPowerfulInteger {
    public static void main(String[] args) {
        System.out.println(numberOfPowerfulInt(1,2000,6,"25"));
    }
    //not solve
    public static int numberOfPowerfulInt(long start,long finish,int limit,String s){
        String fin=""+finish;
        String strt=""+start;
        int suf=Integer.parseInt(s);
        if(suf>start){
            count=1;
            helper(s,fin,limit,1);
        }else if(suf<start){
            count=0;
            helper(""+1+s,fin,limit,1);
        }
        helper(s,fin,limit,1);
        return count;
    }
    static int count;
    public static void helper(String s,String fin,int limit,int add){
        if(s.length()>fin.length()){
            //we need to stop
            return;
        }
        if(add <=limit){
            s=""+ add +s;
            System.out.println(s);
            count++;
            helper(s,fin,limit,add);
            add++;
        }else{
            return;
        }
    }
}

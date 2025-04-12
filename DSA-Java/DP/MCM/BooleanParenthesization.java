package DP.MCM;

import java.util.Arrays;
import java.util.HashMap;

public class BooleanParenthesization {
    public static void main(String[] args) {
        String s="T|T&F^T";
        System.out.println(countWays(s));
    }
    static int countWays(String s) {
        map=new HashMap<>();
        int n=s.length();
        return solve(s,0,n-1,true);
    }
    static HashMap<String,Integer> map;
    static int solve(String s,int i,int j,boolean isTrue){
        //base cond.
        if(i>j) return 0;
        if(i==j){
            if(isTrue==true){
                if(s.charAt(i)=='T') return 1;
                else return 0;
            }else{
                if(s.charAt(i)=='F') return 1;
                else return 0;
            }
        }

        String temp=i+" "+j+" "+isTrue;
        if(map.containsKey(temp)) return map.get(temp);
        int ans=0;
        for(int k=i+1;k<=j-1;k=k+2){
            int lt=solve(s,i,k-1,true);
            int lf=solve(s,i,k-1,false);
            int rt=solve(s,k+1,j,true);
            int rf=solve(s,k+1,j,false);
            if(s.charAt(k)=='&'){
                if(isTrue==true){
                    ans=ans+lt*rt;
                }else {
                    ans=ans+lf*rt+lt*rf+lf*rf;
                }
            }else if(s.charAt(k)=='|'){
                if(isTrue==true){
                    ans=ans+rt*lt+lf*rt+lt*rf;
                }else{
                    ans=ans+rf*lf;
                }
            }else if(s.charAt(k)=='^'){
                if(isTrue==true){
                    ans=ans+lt*rf+lf*rt;
                }else{
                    ans=ans+lt*rt+lf*rf;
                }
            }
        }
        map.put(temp,ans);
        return ans;
    }
}
package Hashing;

import java.util.HashMap;

public class RomantoInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCCCXXXIII"));
    }
    public static int romanToInt(String s) {
        int ans=0;
        HashMap<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("IV",4);
        map.put("V",5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC",90);
        map.put("C",100);
        map.put("CD",400);
        map.put("D",500);
        map.put("CM",900);
        map.put("M",1000);
        int i=0;int n=s.length();
        while(i<n){
            char ch=s.charAt(i);
            if(ch=='I'){
                if(i<n-1 && s.charAt(i+1)=='V'){
                    ans=ans+map.get("IV");i++;
                }else if(i<n-1 &&s.charAt(i+1)=='X'){
                    ans=ans+map.get("IX");i++;
                }else{
                    ans=ans+map.get("I");
                }
            }else if(ch=='X'){
                if(i<n-1 &&s.charAt(i+1)=='L'){
                    ans=ans+map.get("XL");i++;
                }else if(i<n-1 &&s.charAt(i+1)=='C'){
                    ans=ans+map.get("XC");i++;
                }else{
                    ans=ans+map.get("X");
                }
            }else if(ch=='C'){
                if(i<n-1 &&s.charAt(i+1)=='D'){
                    ans=ans+map.get("CD");i++;
                }else if(i<n-1 &&s.charAt(i+1)=='M'){
                    ans=ans+map.get("CM");i++;
                }else{
                    ans=ans+map.get("C");
                }
            }else{
                String t=""+ch;
//                System.out.println(t);
                ans=ans+map.get(t);
            }
            i++;
        }
        return ans;
    }
}

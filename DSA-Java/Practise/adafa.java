package Practise;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class adafa {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
//        System.out.println(helper("23"));
    }
    public static String countAndSay(int n) {
        if(n==1) return "1";
        String prev=countAndSay(n-1);
        return helper(prev);
    }
    public static String helper(String s){
        StringBuilder sb=new StringBuilder();
        int count=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }else{
                sb=sb.append(count).append(s.charAt(i-1));
                count=1;
            }
        }
        //at last append last group
        sb=sb.append(count).append(s.charAt(s.length()-1));
        return sb.toString();
    }
}



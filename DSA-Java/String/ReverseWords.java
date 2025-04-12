package String;

import java.io.StringReader;

public class ReverseWords {
    public static void main(String[] args) {
        String s="i  love";
        System.out.println(reverseWords(s));
    }
    public static String  reverseWords(String s){
        s = s.trim();
        if (s.isEmpty()) return "0";
        String ans="";
        String temp="";
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            temp=ch+temp;
            if(i!=0 && s.charAt(i-1)==' '){
                ans=ans+temp+" ";
                temp="";
            }
            while(i!=0 && s.charAt(i-1)==' '){
                i--;
            }
            if(i==0){
                ans=ans+temp;
            }
        }
        return ans;
    }
}

package SlidingWindow;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {
        String s=" ";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int n=s.length(); if(n==0) return 0;
        if(n==1) return 1;
        int left=0;int right=left+1;
        int len=0,maxlen= Integer.MIN_VALUE;
        HashSet<Character> map=new HashSet<Character>();
        while(right<n){
            map.clear();
            map.add(s.charAt(left));
            //advice...think of removing element from map Main by Main...so there is Main more method.
            //hint: left ko ek ek kr ke htao inner loop se..
            while(right<n && !map.contains(s.charAt(right))){
                map.add(s.charAt(right));
                right++;
            }
            len=map.size();
            maxlen=Math.max(len,maxlen);
            left++;right=left+1;
        }
        return maxlen;
    }
}

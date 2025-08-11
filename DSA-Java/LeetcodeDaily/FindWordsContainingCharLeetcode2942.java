package LeetcodeDaily;

import java.util.*;

public class FindWordsContainingCharLeetcode2942 {
    public static void main(String[] args) {
        String[] arr = {"abc", "bcd", "aaaa", "cbc"};
        System.out.println(findWordsContaining(arr,'z'));
    }
    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++) {
                if (words[i].charAt(j) == x) {
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }
}

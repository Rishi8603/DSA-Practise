package Recursion;
import java.util.*;
public class LetterCombinationPhoneNum {
    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }
    static List<String> list;
    static Map<Integer, String> map;
    public static List<String> letterCombinations(String digits) {
        int j=2;
        map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

//        System.out.println(map);
        list=new ArrayList<>();
        StringBuilder sb=new StringBuilder("");
        helper(digits,sb,0,0);
        return list;
    }
    public static void helper(String digits, StringBuilder sb, int idx, int j){
        if(sb.length()==digits.length()){
            String t=sb.toString();
            list.add(t);
            return;
        }
        //base case
        if(idx==digits.length()) return;

        int currDigit = digits.charAt(idx) - 48;
        for(j = 0; j <map.get(currDigit).length(); j++) {
            char ch=map.get(currDigit).charAt(j);
            sb.append(ch);
            helper(digits, sb, idx+1, j);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}

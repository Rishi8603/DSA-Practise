package Recursion;

import java.util.ArrayList;
import java.util.*;

public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    static List<String> list;
    public static List<String> generateParenthesis(int n) {
        list=new ArrayList<>();
        StringBuilder sb=new StringBuilder("(");
        helper(n,sb,1,0);
        return list;
    }
    public static void helper(int n,StringBuilder sb , int openB,int closeB){
        if(openB<closeB || openB>n){
            return;
        }
        if(sb.length()==2*n){
            String t=sb.toString();
            list.add(t);
//            if(check(t)){
//
//            }
            return;
        }
        if(openB<n) {
            openB++;
            helper(n, sb.append("("),openB,closeB);
            sb.deleteCharAt(sb.length()-1);
            openB--;
        }
        if(closeB<n){
            closeB++;
            helper(n,sb.append(")"),openB,closeB);
            sb.deleteCharAt(sb.length()-1);
            closeB--;
        }
    }
    public static boolean check(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}

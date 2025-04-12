package Stacks;
import java.util.*;

public class BalancedBracket {
    public static boolean isValid(String s){
        Stack<Character> st=new Stack<>();
        for(int i = 0; i< s.length(); i++){
            char ch= s.charAt(i);
            if(ch=='('){
                st.push(ch);
            } else if(ch=='{'){
                st.push(ch);
            }else if(ch=='['){
                st.push(ch);
            }
            if (ch==')') {
                if(st.isEmpty()){
                    return false;
                }else if(st.peek()=='('){
                    st.pop();
                }else{
                    return false;
                }
            }else if(ch=='}'){
                if(st.isEmpty()){
                    return false;
                }else if(st.peek()=='{'){
                    st.pop();
                }else{
                    return false;
                }
            }else if(ch==']'){
                if(st.isEmpty()){
                    return false;
                }else if(st.peek()=='['){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        String str="(*)";
        System.out.println(isValid(str));
    }
}

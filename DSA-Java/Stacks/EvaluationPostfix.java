package Stacks;

import java.util.Stack;


public class EvaluationPostfix {
    public static void main(String[] args) {
        String postfix="953+4*6/-";
        Stack<Integer> val=new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char ch=postfix.charAt(i);
            int ascii=(int)ch;
            if(ascii>=48 && ascii<=57){ // 0 to 9
                val.push(ascii-48);
            }else if(ch=='*'){
                int v2=val.pop();
                int v1=val.pop();
                val.push(v1*v2);
            }else if(ch=='/'){
                int v2=val.pop();
                int v1=val.pop();
                val.push(v1/v2);
            }else if(ch=='+'){
                int v2=val.pop();
                int v1=val.pop();
                val.push(v1+v2);
            }else if(ch=='-'){
                int v2=val.pop();
                int v1=val.pop();
                val.push(v1-v2);
            }
        }
        System.out.println(val.peek());

    }
}

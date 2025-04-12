package Stacks;

import java.util.Stack;

public class EvaluationPrefix {
    public static void main(String[] args) {
        String prefix="-9/*+5346";
        Stack<Integer> val=new Stack<>();
        //the only difference here is, postfix mein sidha loop chalate the
        //yhaan ulta loop chalana hei..
        //the only imp chz is ab stack ke upr wala v1 hoga pehle than v2
        for (int i = prefix.length()-1; i >= 0; i--) {
            char ch=prefix.charAt(i);
            int ascii=(int)ch;
            if(ascii>=48 && ascii<=57){ // 0 to 9
                val.push(ascii-48);
            }else if(ch=='*'){
                int v1=val.pop();
                int v2=val.pop();
                val.push(v1*v2);
            }else if(ch=='/'){
                int v1=val.pop();
                int v2=val.pop();
                val.push(v1/v2);
            }else if(ch=='+'){
                int v1=val.pop();
                int v2=val.pop();
                val.push(v1+v2);
            }else if(ch=='-'){
                int v1=val.pop();
                int v2 =val.pop();
                val.push(v1 -v2);
            }
        }
        System.out.println(val.peek());
    }
}

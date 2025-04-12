package Stacks;

import java.util.Stack;

public class infix {
    public static void main(String[] args) {
        String str="9-(2*(4+4))*3/6";
        Stack<Integer> val=new Stack<>();
        Stack<Character> op=new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            int ascii=(int)ch;
            if(ascii>=48 && ascii<=57) val.push(ascii-48);
            else if(op.size()==0 || ch=='(' || op.peek()=='('){
                op.push(ch);
            }else if(ch==')'){
                //simply solve jb tk opening bracket nhi mile
                while(op.peek()!='(') {
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if (op.peek() == '-') val.push(v1 - v2);
                    else if (op.peek() == '+') val.push(v1 + v2);
                    else if (op.peek() == '*') val.push(v1 * v2);
                    else if (op.peek() == '/') val.push(v1 / v2);
                    op.pop();
                }
                op.pop(); // '(' hata diya isse
            }else {
                if (ch == '+' || ch == '-') {//isme hamesa pehle solve then push
                    //pehle solve
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if (op.peek() == '-') val.push(v1 - v2);
                    else if (op.peek() == '+') val.push(v1 + v2);
                    else if (op.peek() == '*') val.push(v1 * v2);
                    else if (op.peek() == '/') val.push(v1 / v2);
                    op.pop();
                    //then push
                    op.push(ch);
                } else {
                    //check kro ab
                    if (op.peek() == '+' || op.peek() == '-') {
                        //simply push
                        op.push(ch);
                    } else {
                        //pehle solve
                        int v2 = val.pop();
                        int v1 = val.pop();
                        if (op.peek() == '*') val.push(v1 * v2);
                        else if (op.peek() == '/') val.push(v1 / v2);
                        op.pop();
                        //then push
                        op.push(ch);
                    }
                }
            }
        }
        //val stack ka size Main bnana hei, to find answer
        while(val.size()>1){
            int v2=val.pop();
            int v1=val.pop();
            if(op.peek()=='-') val.push(v1-v2);
            else if(op.peek()=='+') val.push(v1+v2);
            else if(op.peek()=='*') val.push(v1*v2);
            else if(op.peek()=='/') val.push(v1/v2);
            op.pop();
        }
        System.out.println(val.peek());
    }
}

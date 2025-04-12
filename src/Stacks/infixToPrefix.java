package Stacks;

import java.util.Stack;

public class infixToPrefix {
    public static void main(String[] args) {
        String infix="9-(5+3)*4/6";
        System.out.println(infix);
        Stack<String> val=new Stack<>();
        Stack<Character> op=new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            char ch=infix.charAt(i);
            int ascii=(int)ch;
            if(ascii>=48 && ascii<=57){ // 0 to 9
                String s= ""+ch;
                val.push(s);
            }
            else if(op.size()==0 || ch=='(' || op.peek()=='('){
                op.push(ch);
            }else if(ch==')'){
                //simply solve jb tk opening bracket nhi mile
                while(op.peek()!='(') {
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char operator=op.pop();
                    String t=operator+v1+v2;
                    val.push(t);
                }
                op.pop(); // '(' hata diya isse
            }else {
                if (ch == '+' || ch == '-') {//isme hamesa pehle solve then push
                    //pehle solve
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char operator=op.pop();
                    String t=operator+v1+v2;
                    val.push(t);
                    //then push
                    op.push(ch);
                } else {
                    //check kro ab
                    if (op.peek() == '+' || op.peek() == '-') {
                        //simply push
                        op.push(ch);
                    } else {
                        //pehle solve
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char operator=op.pop();
                        String t=operator+v1+v2;
                        val.push(t);
                        //then push
                        op.push(ch);
                    }
                }
            }
        }
        while(val.size()>1){
            String v2 = val.pop();
            String v1 = val.pop();
            char operator=op.pop();
            String t=operator+v1+v2;
            val.push(t);
        }
        String prefix=val.pop();
        System.out.println(prefix);
    }
}

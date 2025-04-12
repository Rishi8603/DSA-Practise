package Stacks;

import java.util.Stack;

public class infixKhudSe {
    public static void main(String[] args) {
        int x=9-(5+3)*3/6;
        System.out.println(x);
        String str="9-5+3*4/6";
        Stack<Integer> val=new Stack<>();
        Stack<Character> op=new Stack<>();
        //do loop chale ga, pehla loop se val stack and op stack mein condition ke sath fillup hoga
        //dsra loop mein result print out krna rhega bs, usme bs solve krna hei bina kisi condition ke
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            int ascii=(int)ch;
            //3 condition hei--pehla condition no. ko push krna, dsra condition agr op stack khali hei then simply push,
            // and at last agr op stack bhara hei then usme do condition;
            if(ch>=48 && ch <=57){
                val.push(ascii-48);
            }else if(op.size()==0){
                op.push(ch);
            }else{
                if(ch=='+' || ch=='-'){//isme hamesa pehle solve then push
                    //pehle solve
                    int v2=val.pop();
                    int v1=val.pop();
                    if(op.peek()=='-') val.push(v1-v2);
                    else if(op.peek()=='+') val.push(v1+v2);
                    else if(op.peek()=='*') val.push(v1*v2);
                    else if(op.peek()=='/') val.push(v1/v2);
                    op.pop();
                    //then push
                    op.push(ch);
                }
                else{
                   //check kro ab
                   if(op.peek()=='+' || op.peek()=='-') {
                       //simply push
                       op.push(ch);
                   }else{
                       //pehle solve
                       int v2=val.pop();
                       int v1=val.pop();
                       if(op.peek()=='*') val.push(v1*v2);
                       else if(op.peek()=='/') val.push(v1/v2);
                       op.pop();
                       //then push
                       op.push(ch);
                   }
                }
            }
        }
        //now simply solve
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

package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class reverseKelement {
    public static void main(String[] args) {
        Queue<Integer> q =new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        Scanner sc=new Scanner(System.in);
        System.out.println(q);
        System.out.println("Enter the element upto which you want to reverse for the following Queue: ");
        int num=sc.nextInt();
        reverse(q,num);
    }
    public static void reverse(Queue<Integer> q,int num){
        Stack<Integer> st=new Stack<>();
        int qsize=q.size();
        for (int i = 0; i < num; i++) {
            st.push(q.remove());
        }
        int size1=st.size();
        for (int i = 0; i < size1; i++) {
            q.add(st.pop());
        }
        for (int i = 0; i < qsize-num; i++) {
            q.add(q.remove());
        }
        System.out.println(q);
    }
}

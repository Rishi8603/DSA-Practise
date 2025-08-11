package LinkedList;

import java.util.*;
import java.util.LinkedList;

public class SortLL148Leetcode {
    public static Node sortList(Node head) {
        return brk(head);
    }
    public static Node brk(Node head){
        if(head.next==null) return head;

        //finding middle and breaking into two
        Node slow=head;
        Node fast=head;
        Node prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        Node left=brk(head);
        Node right=brk(slow);
        return merge(left,right);
    }
    public static Node merge(Node h1, Node h2){
        Node h=new Node(100);
        Node t=h;
        Node t1=h1;
        Node t2=h2;

        while(t1!=null && t2!=null){
            int a =Math.min(t1.val,t2.val);
            if(a==t1.val){
                t.next=t1;
                t=t1;
                t1=t1.next;
            }else{
                t.next=t2;
                t=t2;
                t2=t2.next;
            }
        }

        if(t2==null){
            t.next=t1;
        }else{
            t.next=t2;
        }
        return h.next;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(7);
        Node d = new Node(3);
        Node e = new Node(4);
        Node f = new Node(5);
        Node g = new Node(6);


        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next=f;
        f.next=g;
        Node temp=sortList(a);
        while(temp!=null){
            System.out.print(temp.val +" ");
            temp=temp.next;
        }
    }
}

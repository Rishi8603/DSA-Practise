package LinkedList;

import java.math.BigInteger;
import java.util.LinkedList;

public class AddTwoNumbers {
    public static Node addTwoNumbers(Node l1, Node l2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        Node temp1 = l1, temp2 = l2;

        while (temp1 != null) {
            s1.append(temp1.val);
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            s2.append(temp2.val);
            temp2 = temp2.next;
        }

        // Reverse the strings to get correct order
        BigInteger num1 = new BigInteger(s1.reverse().toString());
        BigInteger num2 = new BigInteger(s2.reverse().toString());
        BigInteger sum = num1.add(num2);

        return helper(sum.toString());
    }

    public static Node helper(String numStr) {
        Node dummy = new Node(-1);
        Node temp = dummy;

        for (int i = numStr.length() - 1; i >= 0; i--) {
            int digit = numStr.charAt(i) - '0';
            temp.next = new Node(digit);
            temp = temp.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Node a = new Node(2);
        Node b = new Node(4);
        Node c = new Node(3);

        a.next = b;
        b.next = c;

        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(4);

        d.next = e;
        e.next = f;

        Node temp=addTwoNumbers(a,d);
        while(temp!=null){
            System.out.print(temp.val +" ");
            temp=temp.next;
        }
    }
}

package Queues;

import java.util.*;
import java.util.LinkedList;

public class deque {
    public static void main(String[] args) {
        Deque<Integer> dq=new LinkedList<>();
        //add,remove/poll,peek/element
//        dq.addLast(1);
//        dq.addLast(2);
//        dq.addLast(5);
//        dq.addLast(6);
//        dq.addFirst(55);
//        System.out.println(dq);
//        dq.removeFirst();
//        dq.removeLast();
//        System.out.println(dq);
//        System.out.println(dq.getFirst());
//        System.out.println(dq.getLast());
        dq.addLast(1);
        dq.addLast(2);
        dq.addLast(5);
        dq.addLast(6);
        dq.add(77);//add last krega
        System.out.println(dq);
        dq.remove();//first se remove
        System.out.println(dq);
        dq.removeAll(dq);
        System.out.println(dq);
    }
}



package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class PrintQueue {
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        Queue<Integer> h=new LinkedList<>();
        q.add(2);
        q.add(5);
        q.add(4);
        q.add(24);
        q.add(25);
        int n=q.size();
        for (int i = 0; i < n; i++) {
            System.out.print(q.element()+" ");
            h.add(q.remove());
        }
        System.out.println();
        int nn=h.size();
        for (int i = 0; i < nn; i++) {
            System.out.print(h.element()+" ");
            q.add(h.remove());
        }
    }
}

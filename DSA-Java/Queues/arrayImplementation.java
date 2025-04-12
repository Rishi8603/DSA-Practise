package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class arrayImplementation {
    public static class queueA{
        int f=-1;
        int r=-1;
        int size=0;
        int[] arr=new int[5];
        public void add(int val){
            if(r==arr.length-1){
                System.out.println("Queue is full");
                return;
            }
            if(f==-1) {//queue is empty
                f=r=0;
                arr[0]=val;
            }
            else{
//                arr[r+1]=val;
//                r++;
                //or
                arr[++r] = val;
            }
            size++;
        }
        public int remove(){
            if(size==0){
                System.out.println("Queue is Empty");
                return -1;
            }
            f++;
            size--;
            return arr[f-1];
        }
        public int peek(){
            if(size==0){
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[f];
        }
        public boolean isEmpty(){
            if(size==0) return true;
            else return false;
        }
        public void display(){
            if(size==0){
                System.out.println("Queue is Empty");
                return;
            }
            else{
                for (int i = f; i <=r ; i++) {
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        queueA q1=new queueA();
        q1.display();
        q1.add(4);
        q1.add(5);
        q1.add(45);
        q1.add(5);
        System.out.println(q1.size);
        q1.display();
        q1.remove();
        q1.display();
//        System.out.println(q1.peek());
        System.out.println(q1.size);
        q1.add(1);
        q1.add(55);
    }
}

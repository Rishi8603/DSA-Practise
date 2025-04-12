package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;


public class FindMedianFromDataStream {
    public static class MedianFinder {
        PriorityQueue<Integer> minH;
        PriorityQueue<Integer> maxH;
        public MedianFinder() {
            minH =new PriorityQueue<>();
            maxH =new PriorityQueue<>(Collections.reverseOrder());
        }

        public void addNum(int num) {
            if (maxH.isEmpty()) maxH.add(num);
            else if (minH.isEmpty()) minH.add(num);
            else if (num < minH.peek()) maxH.add(num);
            else minH.add(num);
            //now we need to balance heap
            if(!minH.isEmpty()) {
                if (maxH.peek() > minH.peek()) {
                    minH.add(maxH.remove());
                }
            }
            if(minH.size()>maxH.size()+1) maxH.add(minH.remove());
            else if(minH.size()+1<maxH.size()) minH.add(maxH.remove());
        }

        public double findMedian() {
            double ans=0;
            if(maxH.size()==minH.size()){
                ans=(maxH.peek()+minH.peek())/2.0;
            }else if(maxH.size()>minH.size()){
                ans=maxH.peek();
            }else{
                ans=minH.peek() ;
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);    // arr = [1]
        medianFinder.addNum(-2);    // arr = [1, 2]
//        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
//        medianFinder.addNum(-3);    // arr[1, 2, 3]
//        medianFinder.addNum(-4);
//        medianFinder.addNum(-5);
//        medianFinder.addNum(-6);
//        medianFinder.addNum(-7);
        System.out.println(medianFinder.findMedian());
    }
}

//            if(num<0) {
//                if (minH.isEmpty()) minH.add(num);
//                else if (maxH.isEmpty()) maxH.add(num);
//                else if (num > minH.peek()) maxH.add(num);
//                else minH.add(num);
//            }else{
//                if (maxH.isEmpty()) maxH.add(num);
//                else if (minH.isEmpty()) minH.add(num);
//                else if (num < minH.peek()) maxH.add(num);
//                else minH.add(num);
//            }

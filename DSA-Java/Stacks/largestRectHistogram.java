package Stacks;

import java.util.*;
import java.util.Stack;

public class largestRectHistogram {
    public static void main(String[] args) {
        int[] arr={2,1,4,5,1,3,3};
        int ans= largestRectangleArea(arr);
        System.out.println(ans);
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea= Integer.MIN_VALUE;
        int[] NextS = nse(heights);
        System.out.println(Arrays.toString(NextS));
        int[] PrevS = pse(heights);
        System.out.println(Arrays.toString(PrevS));
        for (int i = 0; i < heights.length; i++) {
            int area=heights[i]*(NextS[i]-PrevS[i]-1);
            if(area>maxArea) maxArea=area;
        }
        return maxArea;
    }

    public static int[] pse(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        res[0] = -1;
        st.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] < arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                res[i] = -1;
            } else if (arr[i] > arr[st.peek()]) {
                //indices store kr rhe hein
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }
    public static int[] nse(int[] arr){
        int[] res=new int[arr.length];
        Arrays.fill(res,arr.length);
        Stack<Integer> st=new Stack<>();
        st.push(0);
        for (int i = 1; i < arr.length; i++) {
            while(!st.isEmpty()&& arr[i]<arr[st.peek()]){
                //indices store kro
                res[st.peek()]=i;
                st.pop();
            }
            st.push(i);
        }
        return res;
    }
}
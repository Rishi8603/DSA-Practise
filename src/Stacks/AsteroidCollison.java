package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollison {
    public static void main(String[] args) {
        int[] nums={-2,-1,1,-2};
        System.out.println(Arrays.toString(asteroidCollision(nums)));
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            boolean survive =true;
            while(survive && st.size()>0 && (asteroids[i]<0 && st.peek()>0)) {
                if (Math.abs(asteroids[i]) == st.peek()) {
                    st.pop();
                    survive = false;
                } else if ((Math.abs(asteroids[i]) > st.peek())) {
                    st.pop();
                } else {
                    survive = false;
                }
            }
            if(survive){
                st.push(asteroids[i]);
            }
        }
        int[] res = new int[st.size()];
        int i = st.size() - 1;
        while (st.size() > 0) {
            res[i] = st.pop();
            i--;
        }
        return res;
    }
}

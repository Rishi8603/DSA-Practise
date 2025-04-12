package Basic;

import java.util.ArrayList;
import java.util.List;

public class swapping {
    public static void main(String[] args) {
        int a=8;
        int b=5;
        System.out.println(get(a,b));
    }
    public static List<Integer> get(int a, int b) {
        // code here
        List<Integer> list=new ArrayList<>();
        a=a+b;
        b=a-b;
        a=a-b;
        list.add(a);
        list.add(b);
        return list;
    }
}

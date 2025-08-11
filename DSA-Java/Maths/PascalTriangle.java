package Maths;

import java.util.*;

public class PascalTriangle {
    public static void main(String[] args) {
        int num=5;
        System.out.println(generate(num));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ans;
        int sum=0;
        int left;
        int right;
        for(int i=1;i<=numRows;i++){
            ans=new ArrayList<>();
            for(int j = 1; j <=i; j++){
                if(j==1 || j==i){
                    ans.add(1);
                }else {
                    left=j-1;right=j;
                    sum = res.get(res.size() - 1).get(left-1) + res.get(res.size() - 1).get(right-1);
                    ans.add(sum);
                }
            }
            res.add(ans);
        }
        return res;
    }
}

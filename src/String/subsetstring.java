package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class subsetstring {
    public static void main(String[] args) {
        String s="shashank";
        char[] arr = s.toCharArray();

        Arrays.sort(arr);
        String st = "";
       for(int i = 0 ; i < arr.length; i++){
          st = st + arr[i];
       }
        System.out.println(st);

        HashMap<Character,Integer> map = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();
        ans.add("");

        for(int i=0;i<st.length();i++){
            char ch = st.charAt(i);
            if(map.containsKey(ch)){
               int val =  map.get(ch) + 1;
               map.put(ch,val);
            }else{
                map.put(ch,1);
            }

            int size = ans.size();
            if(map.get(ch) == 1) {
                for (int j = 0; j < size; j++) {
                    ans.add( ans.get(j) + ch);
                }
            }else{
                for(int j = size - 2  ; j < size ; j++){
                    ans.add( ans.get(j) + ch);
                }
            }
        }

        for(int i = 0 ; i < ans.size(); i++){
            System.out.print("["+ ans.get(i)+"]" +" ");
        }
    }

}

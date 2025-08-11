package LeetcodeDaily;

import java.util.HashMap;

public class LongestPalindromeByConcatenatingTwoLetterWordsLeetcode2131 {
    public static void main(String[] args) {
        String[] words = {"ll","lb","bb","bx","xx","lx","xx","lx","ll","xb","bx","lb","bb","lb","bl","bb","bx","xl","lb","xx"};
        System.out.println(longestPalindrome(words));
    }
    public static int longestPalindrome(String[] words) {
        int count=0;
        HashMap<String,Integer> map=new HashMap<>();

        //map update
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        boolean mid =true;
        for(int j=0;j<words.length;j++){
            String st=words[j];
            String st1=""+st.charAt(1)+st.charAt(0);
            if (map.containsKey(st1)) {
                if(st.equals(st1)){
                    int temp = map.get(st1);

                    if(temp%2==0){
                        count=count+temp;
                    }else{
                        if(mid) {
                            count = count + temp;
                            mid = false;
                        }else{
                            temp--;
                            count=count+temp;
                        }
                    }
                    map.remove(st);

                }else{
                    //removing st1
                    int temp1 = map.get(st1);
                    int temp = map.get(st);
                    count=count+2*Math.min(temp1,temp);
                    map.remove(st);
                    map.remove(st1);
                }
            }
        }
        return 2*count;
    }
}

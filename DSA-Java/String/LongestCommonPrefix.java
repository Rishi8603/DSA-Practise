package String;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs={"cir","car"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        String ans="";
        for(int i=0;i<strs[0].length();i++){
            char ch0=strs[0].charAt(i);
            boolean check=true;
            for(int j=1;j<strs.length;j++){
                if(i<strs[j].length()) {
                    char ch = strs[j].charAt(i);
                    if (ch0 != ch) {
                        check = false;
                        break;
                    }
                }else{
                    check=false;
                }
            }
            if(check) ans=ans+ch0;
            else break;
        }
        return ans;
    }
}

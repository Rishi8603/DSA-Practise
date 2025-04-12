package String;

public class LargestOddNumberInString {
    public static void main(String[] args) {
        String s="35427";
        System.out.println(largestOddNumber(s));
    }
    public static String largestOddNumber(String num) {
        String ans="";
        int i=num.length()-1;
        while(i>=0){
            int ch=num.charAt(i);
            int x= (int)ch-48;
            if(x%2!=0){
                ans=num.substring(0,i+1);
                return ans;
            }
            i--;
        }
        return "";
    }
}

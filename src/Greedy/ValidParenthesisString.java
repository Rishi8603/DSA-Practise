package Greedy;

public class ValidParenthesisString {
    public static boolean checkValidString(String s) {
        return helper(s,0,0);
    }
    //bruteforce---tle for larger string
    public static boolean helper(String s,int count,int idx){
        if(count<0) return false;
        if(idx==s.length()){
            if(count==0) return true;
            else return false;
        }
        char c=s.charAt(idx);
        if(c=='('){
            return helper(s,count+1,idx+1);
        }else if(c==')'){
            return helper(s,count-1,idx+1);
        }else{
            boolean option1 = helper(s, count + 1, idx + 1);
            boolean option2 = helper(s, count - 1, idx + 1);
            boolean option3 = helper(s, count, idx + 1);

            return option1 || option2 || option3;
        }
    }
    public static void main(String[] args) {
        String s="(";
        System.out.println(checkValidString(s));
    }
}

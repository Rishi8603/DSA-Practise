package String;

public class RemoveOutermostParenthese {
    public static void main(String[] args) {
//        String  s = "(()())(())(()(()))";
        String  s = "(()(()))";
        System.out.println(removeOuterParentheses(s));
    }
    public static String removeOuterParentheses(String s) {
        String ans="";
        int i = 0;
        while ( i < s.length()) {
            char ch=s.charAt(i);
            if(ch=='('){
                if(s.charAt(i+1)==')'){
                    ans=ans+ch+')';
                }
            }
            i++;
        }
        return ans;
    }
}

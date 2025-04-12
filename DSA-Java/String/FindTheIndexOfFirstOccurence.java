package String;

public class FindTheIndexOfFirstOccurence {
    public static void main(String[] args) {
        String s="mississippi";
        String t="issip";
        System.out.println(strStr(s,t));
    }
    public static int strStr(String haystack,String needle){
        int j =0;
        int i=0;
        while(i<haystack.length()&&j<needle.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if(j==needle.length()){
                    return  i-needle.length();
                }
            } else {
                // Mismatch, reset j to 0 and adjust i
                i = i - j + 1; // Backtrack i to start from the next position
                j = 0;         // Reset needle pointer
            }
        }
        return -1;
    }
}

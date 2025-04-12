package Maths;

public class anagram {
    public static void main(String[] args) {
        System.out.println(search("anagrama","nagaram"));
    }
    static boolean search(String s, String t){
        int i=0;
        while(i<=s.length()){
            char ch1=s.charAt(i);
            int j=0;
            while(j<=t.length()){
                char ch2=t.charAt(j);
                if(ch1==ch2){
                    i++;
                    j++;
                }else{
                    j++;
                }
                return true;
            }

        }
        return  false;
    }
}

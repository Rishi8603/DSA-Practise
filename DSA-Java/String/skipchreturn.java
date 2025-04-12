package String;

public class skipchreturn {
    public static void main(String[] args) {
        String s=skip("baccadah");
        System.out.println(s);
    }

    static String skip(String up){
        if(up.isEmpty()){
            return"";
        }
        char ch=up.charAt(0);

        if(ch == 'a'){
            return skip(up.substring(1));
        }
        else{
            return ch + skip(up.substring(1));
        }
    }
}

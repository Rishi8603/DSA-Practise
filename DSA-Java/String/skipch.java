package String;

public class skipch {
    public static void main(String[] args) {
        skip("","baccadah");
    }
    //p-processed, up-unprocessed
    static void skip(String p, String up){
        //base condition
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        if(ch=='a'){
            skip(p,up.substring(1));
        }else{
            skip(p+ch,up.substring(1));
        }
    }
}

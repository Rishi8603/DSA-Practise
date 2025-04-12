package Maths;

public class VarArgs {
    public static void main(String[] args) {
       int ans= sum(7,50);
       System.out.println(ans);

        int res = sum(55,55);
        System.out.println(res);

    }
    static int sum(int a,int b){
        return a+b;
    }
    static int sum(int x,int y,int z){
       return x+y+z;
    }
}

package Maths;

public class reverseUsingRecursion {
    public static void main(String[] args) {
        int n=120;
        rev(n);
//        System.out.println(ans);
    }
    static void rev(int n){
        if(n==0) {
            return;
        }

        System.out.print(n%10);
      rev(n/10);

    }
}

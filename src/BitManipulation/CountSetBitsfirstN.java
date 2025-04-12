package BitManipulation;
import java.util.*;

public class CountSetBitsfirstN {
    public static void main(String[] args) {
        int n=0;
        System.out.println(count(n));
    }
    public static int count(int n){
        if(n==0) return 0;
        int temp=n;
        int i=-1;
        while(temp!=0){
            temp=temp>>1;
            i++;
        }
        int val1= (int) Math.pow(2,i);
        int val2=(int) Math.pow(2,i-1);
        int Msb1= (int) (n-(val1-1));
        int Upper1= (int) (i*(val2));

        return Msb1+Upper1+count(n-(val1));
    }
}

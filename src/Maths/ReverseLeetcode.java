package Maths;

public class ReverseLeetcode {
    public static void main(String[] args) {
        int n=-123;
        System.out.println(reverse(n));
    }
    public static int reverse(int x){
        double sum=0;
        int temp= x;
        for (int i = 0; !(temp==0); i++) {
            int rem=temp%10;
            int j =0;
            while(!(x ==0)){
                x = x /10;
                j++;
            }
            sum=sum+helper(rem,j);
            temp=temp/10;
            x =temp;
        }
        return (int) sum;
    }
    public static double helper(int val,int i){
        double result=Math.pow(10,i-1);
        double t=result*val;
        return t;
    }
}

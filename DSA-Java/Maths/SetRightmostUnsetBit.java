package Maths;

public class SetRightmostUnsetBit {
    public static void main(String[] args) {
        System.out.println(setBit(5));
    }
    public static int setBit(int n) {
        int idx=rightmostUnsetBitIndex(n);
        int val1 =n;
        int val2=n;
        int count=0;
        while(val1 !=0){
            val1 = val1 >>1;
            count++;
        }

        int temp=n&1;
        if(temp==0){
            return n+1;
        }else if(count<idx){
            n=n<<1;
            return n+1;
        }else{
           int x=(int)Math.pow(2,idx);
           val2=val2^x;
           return val2;
        }
    }
    public static int rightmostUnsetBitIndex(int n){
        int mask = (n + 1) & ~n;  // Isolate the rightmost unset bit
        return (int)(Math.log(mask) / Math.log(2));  // Get 1-based index
    }
}

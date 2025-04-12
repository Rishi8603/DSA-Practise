package Maths;

public class LCM {
    public static void main(String[] args) {
        System.out.println(Lcm(9,7));
    }
    public static int Lcm(int n1,int n2){
        int ans=1;
        for(int i=1;i<=n1*n2;i++){
            if(i%n1==0 && i%n2==0){
                ans=i;
                break;
            }
        }
//        int left=1;int right=1;
//        while(left<=n1 && right<=n2){
////            if(left*right)
//        }
        return ans;
    }
}

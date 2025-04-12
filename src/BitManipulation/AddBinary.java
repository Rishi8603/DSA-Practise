package BitManipulation;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("11","1"));
    }
    public static String addBinary(String a, String b) {
        int m=a.length();
        int n=b.length();
        StringBuilder ans=new StringBuilder();
        int i=m-1,j=n-1,carry=0;
        while(i>=0 || j>=0 ||carry>0){
            int sum=carry;
            if(i>=0) sum+=a.charAt(i--) - 48;
            if(j>=0) sum+=b.charAt(j--) - 48;

            ans.append(sum%2);
            carry=sum/2;
        }

        return ans.reverse().toString();
    }
}

package Arrays;

public class maximumwealth {
    public static void main(String[] args) {
        int[][] accounts={{1,5},{7,3},{3,5}};

        System.out.println(maximumWealth(accounts));
    }
    static int maximumWealth(int[][] accounts){
        int max=0;
        for(int person=0;person< accounts.length;person++){
            int sum=0;
            for(int account=0;account<accounts[person].length;account++){
                sum=sum+accounts[person][account];

            }
            if(sum>max){
                max=sum;
            }
        }
        return max;
    }

}

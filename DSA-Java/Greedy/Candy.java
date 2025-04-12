package Greedy;

public class Candy {
    public static int candy(int[] ratings) {
        int n=ratings.length;
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=1;right[n-1]=1;
        //left neighbour
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                left[i]=left[i-1]+1;
            }else{
                left[i]=1;
            }
        }
        //right neighbour
        for(int j = n-1; j >=0; j--){
            if(ratings[j]>ratings[j+1]){
                right[j]=right[j+1]+1;
            }else{
                right[j]=1;
            }
        }
        int sum=0;
        for(int k=0;k<n;k++){
            sum=sum+Math.max(left[k],right[k]);
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] rating={0,2,4,3,2,1,1,3,5,6,4,0,0};
        System.out.println(candy(rating));
    }
}

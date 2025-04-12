package Arrays;

public class Maximum {
    public static void main(String[] args) {
        int[] arr= {-200,-55,-44,-33,-22,0,1,2,3,4,5,6,78,9,99,00,};
        int max=Integer.MIN_VALUE;
        int i=0;
        while(i<arr.length){
            if(arr[i]>max) {
                max = arr[i];
            }
            i++;
        }
            System.out.println(max);
    }
}

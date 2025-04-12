package Arrays;

public class evendigit {
    public static void main(String[] args) {
        int[] arr={1,124,9,174,98,18};
        int ans=evensearch(arr);
        System.out.println(ans);
    }
    static int evensearch(int[]arr){
        int count=0;
        int start=0;
        while(start<=arr.length-1){
            if (arr[start]%2==0) {
                count++;
                start++;
            }
            else{
                start++;
            }
        }
        return count;
    }
}

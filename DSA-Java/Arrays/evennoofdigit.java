package Arrays;

public class evennoofdigit {
    public static void main(String[] args) {
        int[] arr={12,345,2,6,7896};
        System.out.println(findNumbers(arr));
    }
    //now we have passed the array in search fun...now it will take number Main by Main and will send it to evencheck function to check whether that no is even or not...
    static int findNumbers(int[] arr){
        int start =0;
        int count=0;
        while(start<arr.length){
            if(evencheck(arr[start])){
                count++;
            }
            start++;
        }
        return count;
    }
    static boolean evencheck(int num){
        int count=0;
        while(num!=0){
            num=num/10;
            count++;
        }
        if(count%2==0){
           return true;
        }
        else{
           return false;
        }
    }
}

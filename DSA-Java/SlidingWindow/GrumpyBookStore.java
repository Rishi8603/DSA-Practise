package SlidingWindow;

public class GrumpyBookStore {
    public static void main(String[] args) {
        int[] customers={1,0,1,2,1,1,7,5};
        int[] grumpy={0,1,0,1,0,1,0,1};
        System.out.println(maxSatisfied(customers,grumpy,3));
    }
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int left=0,custS=0,maxCustSatisfied=0,sum=0,total=0;
        int n=grumpy.length;
        int right=minutes-1;
        for(int j=0;j<n;j++){
            if(grumpy[j]==0){
                total=total+customers[j];
            }
            if(j<minutes && grumpy[j]==1){
                custS=custS+customers[j];
            }
        }
        System.out.println(total);
//        for(int i=0;i<minutes;i++){
//            if(grumpy[i]==1){
//                custS=custS+customers[i];
//            }
//        }
        maxCustSatisfied=custS;
        left++;right++;
        while(right<customers.length){
            if(grumpy[left-1]==1){
                custS=custS-customers[left-1];
            }
            if(grumpy[right]==1){
                custS=custS+customers[right];
            }

            maxCustSatisfied=Math.max(custS,maxCustSatisfied);
            right++;left++;
        }
        total=total+maxCustSatisfied;
        return total;
    }
}

package Contest;
import java.util.*;
public class SkibdiTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // number of test cases
        while (t-- > 0) {
//            System.out.print("Size:");
            int n = sc.nextInt();
            int size=1<<n;
//            System.out.print("Question:");
            int question=sc.nextInt();
            for (int i = 0; i < question; i++) {
//                System.out.print("Kya chahiye:");
                String in = sc.next();
                if (in.equals("->")){
//                    System.out.print("row & col do:");
                    int row = sc.nextInt();
                    int col = sc.nextInt();
                    System.out.println(getValue(row-1,col-1,0,0,size));
                }else{
//                    System.out.print("num bta:");
                    int num = sc.nextInt();
                    posFound=null;
                    findPositon(num,0,0,size,1);
                    if(posFound!=null) {
                        System.out.println(posFound);
                    }else{
                        System.out.println("-1 -1");
                    }
                }
            }
        }
        sc.close();
//        helper(2);
//        System.out.println(search(15));
    }
    //recursive function to getValue
    public static int getValue(int row, int col, int x, int y, int size){
        //base cond
        if (size == 2) {
            int[][] base = {
                    {1, 4},
                    {3, 2}
            };
            return base[row - x][col - y];
        }
//      Divide current grid into 4 quadrants
//      area is how many numbers in each quadrant.
        int half = size / 2;
        int area = half * half;


        //x and y is used to reflect top-left corner of the following subgrid
        if(row < x+half && col < y+half){//top left quadrant
            return getValue(row,col,x,y,half);
        }else if(row>=x+half && col>=y+half){//bottom right quadrant
            return 1*area + getValue(row,col,x+half,y+half,half);
        }else if(row>=x+half && col<y+half){//bottom left quadrant
            return 2*area + getValue(row,col,x+half,y,half);
        }else{
            return 3*area + getValue(row,col,x,y+half,half);
        }
    }
    //recursive function to find posn of num
    static String  posFound;
    //x and y is used to reflect top-left corner of the following subgrid
    public static void findPositon(int target,int x,int y,int size,int start){
        if (posFound != null) return; // already found

        // base condition
        if (size == 2) {
            int[][] order = {
                    {0, 0},  // 1st number (start)
                    {1, 1},  // 2nd
                    {1, 0},  // 3rd
                    {0, 1}   // 4th
            };
            for (int k = 0; k < 4; k++) {
                if (start + k == target) {
                    int dx = order[k][0];
                    int dy = order[k][1];
                    posFound = (x + dx + 1) + " " + (y + dy + 1); // 1-based indexing
                    return;
                }
            }
            return;
        }

        int half = size / 2;
        int area = half * half;

        // Check each quadrant
        if (target < start + area) {
            // top-left
            findPositon(target, x, y, half, start);
        } else if (target < start + 2 * area) {
            // bottom-right
            findPositon(target, x + half, y + half, half, start + area);
        } else if (target < start + 3 * area) {
            // bottom-left
            findPositon(target, x + half, y, half, start + 2 * area);
        } else {
            // top-right
            findPositon(target, x, y + half, half, start + 3 * area);
        }
    }
}

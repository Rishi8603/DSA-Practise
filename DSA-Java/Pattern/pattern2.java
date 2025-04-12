package Pattern;

public class pattern2 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int s = 0; s < 5 - i - 1; s++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            for (int ss = 0; ss < 5 - i - 1; ss++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = 0; i < 5; i++) {
            for (int s = 0; s<i; s++) {
                System.out.print(" ");
            }
            for (int j = 0 ; j<10-(2*i+1) ; j++) {
                System.out.print("*");
            }
            for (int ss = 0; ss<i; ss++) {
                System.out.print(" ");
            }
                System.out.println();

        }
    }
}

package Basic;

import java.util.Scanner;

public class Switchq1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter any month name :");
        String month=in.next();

        switch(month){
            case "January":
            case "March":
            case "May":
            case "July":
            case "August":
            case "October":
            case "December":
                System.out.println("this month has 31 days");
            break;
            case "April":
            case "June":
            case "September":
            case "November":
                System.out.println("this month has 30 days");
                break;
            case "February":
                System.out.println("this has 28 days");

            default:
                System.out.println("enter correct month");
        }
    }
}

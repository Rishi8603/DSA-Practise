package OOPs;

import java.util.Scanner;

public class oopspractise {
    public static void main(String[] args) {
        Student Rishi = new Student();
        Rishi.setDetails(1,"Banka","rishiii");
        Student Kunal = new Student();
        Kunal.setDetails(2,"Bank","ris");
        Student Ayesha = new Student();
        Ayesha.setDetails(3,"Ban","r");

//        Scanner in=new Scanner(System.in);
//        System.out.println("Enter Name of the Student for which you want Details:");
//        String name=in.nextLine();
//        System.out.println(name);
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Name of the Student for which you want Details:");
        String name = in.nextLine();

        // Checking for the student and printing details
        if (name.equalsIgnoreCase("Rishi")) {
            System.out.println(Rishi);
        } else if (name.equalsIgnoreCase("Kunal")) {
            System.out.println(Kunal);
        } else if (name.equalsIgnoreCase("Ayesha")) {
            System.out.println(Ayesha);
        } else {
            System.out.println("Student not found!");
        }

        // Closing scanner to avoid resource leak
        in.close();
    }
}
class Student{
    int Rollno;
    String Home;
    String Email;
    void setDetails(int newRollno,String newHome,String newEmail){
        Rollno=newRollno;
        Home=newHome;
        Email=newEmail;
    }
    public String toString() {
        return "Roll No: " + Rollno + ", Home: " + Home + ", Email: " + Email;
    }
}
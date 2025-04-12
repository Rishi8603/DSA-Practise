package BinarySearch;

import java.util.Scanner;

public class searchinstring {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("Enter any word dear:");
        String name= in.nextLine();
        System.out.println("Enter letter you want to find in that word :) ->");
        char target = in.next().charAt(0);
//        String name = "Rishi";
//        char target = 's';
        boolean found = search(name,target);
//        System.out.println(search(name,target));
        if(found){
            System.out.println("Congrats ...the letter you were searching is there in that word....hurraay");
            in.nextLine();
            System.out.println("Anything else you want?(say yes or no)");
            String input2 = in.nextLine();
            String store="yes";
            if(input2.equals(store)){
                System.out.println("So tell me what you want..");
                System.out.println("Choose option from 1 to 4:");
                int opt = in.nextInt();
                switch (opt){
                    case 1:
                        System.out.println("Hello");
                        break;
                    case 2:
                        System.out.println("Hi");
                        break;
                    case 3:
                        System.out.println("Bye");
                        break;
                    case 4:
                        System.out.println("Tata");
                        break;

                }

            }else{
                System.out.println("Okay...See you later :))");
            }
        }else{
            System.out.println("Sorry the letter you were searching is not there..");
        }
    }


    static boolean search(String str,char target){
            if(str.length()==0){
                return false;
            }
        for (int i = 0; i < str.length(); i++) {
            if(target==str.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}

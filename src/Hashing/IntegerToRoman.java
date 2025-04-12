package Hashing;

import java.util.HashMap;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(61));
    }

    public static String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        //I-1,X-10,L-50,C-100,D-500,M-1000
        //a numeral can only be subtracted from next two highest values
        //only Main subtraction per numeral pair is allowed
        String s = "";
        int i = 0;
        int temp = 0;
        while (num > 0) {
            temp = num % 10;
            int x = (int) Math.pow(10, i);
            temp = temp * x;
            if (map.containsKey(temp)) {
                s = "" + map.get(temp) + s;
            } else if (map.containsKey(temp - 1 * x)) {
                if ((temp) % 3 != 0) {
                    s = "" + map.get(temp - 1 * x) + map.get(temp - 1 * x) + s;
                } else {
                    int k = temp - 1 * x;
                    int left = temp - k;
                    s = "" + map.get(temp - 1 * x) + map.get(left)+s;
                }
            } else if (map.containsKey(temp - 2 * x)) {
                if (temp % 7 != 0) {
                    s = "" + map.get(temp - 2 * x) + map.get(temp - 2 * x) + map.get(temp - 2 * x) + s;
                } else {
                    int k = temp - 2 * x;
                    int left = (temp - k) / 2;
                    s = "" + map.get(temp - 2 * x) + map.get(left) + map.get(left) + s;
                }
            } else if (map.containsKey(temp - 3 * x)) {
                int k = temp - 3 * x;
                int left = (temp - k) / 3;
                s = "" + map.get(temp - 3 * x) + map.get(left) + map.get(left) + map.get(left) + s;
            }
            num = num / 10;
            i++;
        }
        return s;
    }
}
//    public static String helper(int num,HashMap<Integer,String> map){
//        String ans="";
//        while(n>0){
//            if(num<=5){
//            if(num==5) {
//                s=s+map.get(5);
//                 num=num-5;
//            }
//        else if(num==5-1){
//            s=s+map.get(1)+map.get(5);
//            num=num-4;
//        }else{
//            s=s+map.get(1);
//            num=num-1;
//        }
//    }else if(num>5 && num<=10){
//        if(num==10) {
//            s=s+map.get(10);
//            num=num-10;
//        }
//        else if(num==10-1){
//            s=s+map.get(1)+map.get(10);
//            num=num-9;
//        }else{
//            s=s+map.get(1);
//            num=num-1;
//        }
//    }else if(num>10 && num<50){
//
//    }else if(num>50 && num<100){
//
//    }else if(num>100 && num<500){
//
//    }else if(num>500 && num<1000){
//
//    }else{
//
//    }
//        }
//        return ans;
//    }


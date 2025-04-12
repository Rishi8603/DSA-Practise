package String;

import java.util.HashMap;
import java.util.HashSet;

public class AlienDictionaryLeetcod {
    public static void main(String[] args) {
        String[] words= {"hello","leetcode"};
        String order="hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words,order));
    }
    public static boolean isAlienSorted(String[] words, String order) {
// Create a HashMap for character order
        HashMap<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];

            // Check if second is a prefix of first
            if (first.length() > second.length() && first.startsWith(second)) {
                return false;
            }

            int k = 0;
            while (k < first.length() && k < second.length()) {
                char ch1 = first.charAt(k);
                char ch2 = second.charAt(k);

                if (ch1 != ch2) {
                    // Use HashMap for O(1) character order lookup
                    if (orderMap.get(ch1) > orderMap.get(ch2)) {
                        return false;
                    }
                    break;
                }
                k++;
            }
        }
        return true;

        //Method-2
//        for (int i = 0; i < words.length-1; i++) {
//            String first = words[i];
//            String second = words[i + 1];
//
//            // Check for invalid order case(if "abc" pehle aa gya "ab" ke)
//            if (first.length() > second.length() && first.startsWith(second)) {
//                return false;
//            }
//            int k=0;
//            while  (k < first.length() && k < second.length()) {
//                char ch1 = first.charAt(k);
//                char ch2 = second.charAt(k);
//                if (ch1 != ch2) {
//                    if(order.indexOf(ch1)>order.indexOf(ch2)) return false;
//                    break;
//                }
//                k++;
//            }
//        }
//        return true;
    }
}

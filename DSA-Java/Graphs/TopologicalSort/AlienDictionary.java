package Graphs.TopologicalSort;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] words= {"dddc", "a", "ad", "ab", "b", "be", "cd", "cded"};
        System.out.println(findOrder(words));
    }
    public static String findOrder(String[] words) {
        // Create an adjacency list for 26 letters (from 'a' to 'z')
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        // Array to track in-degrees of each letter
        int[] inDegree = new int[26];

        // Boolean array to record which letters actually appear in the words
        boolean[] visited = new boolean[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                visited[c - 'a'] = true;
            }
        }

        // Build the graph by comparing adjacent words
        for (int i = 0; i < words.length-1; i++) {
            String first = words[i];
            String second = words[i + 1];

            // Check for invalid order case(if "abc" pehle aa gya "ab" ke)
            if (first.length() > second.length() && first.startsWith(second)) {
                return "";
            }
            int k=0;
            while  (k < first.length() && k < second.length()) {
                char ch1 = first.charAt(k);
                char ch2 = second.charAt(k);
                if (ch1 != ch2) {
                    adj.get(ch1 - 'a').add(ch2 - 'a');
                    inDegree[ch2 - 'a']++;
                    break;
                }
                k++;
            }
        }
        System.out.println(adj);
        System.out.println(Arrays.toString(inDegree));
        System.out.println(Arrays.toString(visited));

        //topological sort using KAHN'S ALGO
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            // Only add the letter if it appears in the words and its in-degree is 0.
            if (visited[i] && inDegree[i] == 0) {
                q.add(i);
            }
        }
        String ans="";
        while(q.size()>0) {
            int front=q.remove();
            char ch=(char)('a'+front);
            ans=ans+ch+"";
            for(int ele:adj.get(front)) {
                inDegree[ele]--;
                if (inDegree[ele] == 0) {
                    q.add(ele);
                }
            }
        }
        // Count the number of letters that appear in the input.
        int totalAppearing = 0;
        for (boolean b : visited) {
            if (b) totalAppearing++;
        }
        if(ans.length()== totalAppearing) return ans;
        else return "";
    }
}

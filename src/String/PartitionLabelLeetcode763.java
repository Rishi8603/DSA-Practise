package String;
import java.util.*;
public class PartitionLabelLeetcode763 {
    public static void main(String[] args) {
        String s="eccbbbbdec";
        System.out.println(partitionLabels(s));
    }
    public static List<Integer> partitionLabels(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        HashSet<Character> set=new HashSet<>();
        ArrayList<Integer> list=new ArrayList<>();
        int left=0;int right=0;
        while(right<n){
            char ch=s.charAt(right);
            map.put(ch,map.get(ch)-1);

            if(map.get(ch)!=0){
                set.add(ch);
                int temp =right+1;
                while(temp <n && !set.isEmpty()){
                    char ch2=s.charAt(temp);
                    map.put(ch2,map.get(ch2)-1);
                    if(map.get(ch2)==0){
                       if(set.contains(ch2)) set.remove(ch2);
                       if(set.isEmpty()) break;
                    }else{
                        set.add(ch2);
                    }
                    temp++;
                }
                int len=temp-left+1;
                list.add(len);
                left = temp+1;
                right = left;
            }else {
                int len = right - left + 1;
                list.add(len);
                left++;right++;
            }
        }
        return list;
    }
}

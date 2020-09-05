package Questions.Hashing_7;

import java.util.HashSet;
import java.util.Set;

public class MaxLengthSubString {
    public static void main(String[] args) {
        String s="abcabcbb";
        System.out.println(maxLengthSubstring(s));
    }
    static int maxLengthSubstring(String A) {
        HashSet<Character> hs =new HashSet<Character>();
        int i=0,j=0,max_length=0;
        while(j<A.length()){
            if(!hs.contains(A.charAt(j))){
                hs.add(A.charAt(j));
                j++;
                max_length=Math.max(max_length,hs.size());
            }
            else{
                hs.remove(A.charAt(i));
                i++;
            }
        }
        return max_length;
    }
}

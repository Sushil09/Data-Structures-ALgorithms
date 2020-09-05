package Questions.DP_15;

import java.util.HashSet;
import java.util.Set;

public class RepeatingSubSequence {
    public static void main(String[] args) {
        String s="xyxzyrzx";
        System.out.println(isPresent(s.toCharArray()));
    }
    static boolean isPresent(char[]c){
        Set<Character> hs=new HashSet<>();
        int count=0;
        for(int i=0;i<c.length;i++){
            if(hs.contains(c[i])){
                count++;
                hs.remove(c[i]);
            }
            else
                hs.add(c[i]);
            if(count==2)
                return true;
        }
        return false;
    }
}

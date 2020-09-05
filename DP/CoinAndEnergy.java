package Questions.DP_15;

import java.util.ArrayList;
import java.util.HashSet;

public class CoinAndEnergy {
    public static void main(String[] args) {
        String s="madamciviclevel";
        if(s.length()<3)
            System.out.println("Impossible");
        else{
            ArrayList<String> ans=splitString(s);
            if(ans.size()<3)
                System.out.println("Impossible");
            else{
                for(String x:ans)
                    System.out.println(x);
            }
        }
    }
    static ArrayList<String> splitString(String s){
        ArrayList<String> ans=new ArrayList<>();
        int N=s.length();
        if(isPalin(s,0,N-1)){
            if(sameCharacter(s)){
                ans.add(s.substring(0,1));
                ans.add(s.substring(1,2));
                ans.add(s.substring(2,s.length()));
            }
            else{
                ans.add(s.substring(0,1));
                ans.add(s.substring(1,s.length()-1));
                ans.add(s.substring(s.length()-1,s.length()));
            }
        }
        else {
            int i=0,j=1;
            while (j<N){
                if(isPalin(s,i,j)){
                    ans.add(s.substring(i,j+1));
                    i=j+1;
                    j=i+1;
                }
                else
                    j++;
            }
        }
        return ans;
    }
    static boolean isPalin(String s,int i,int j){
        while (i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else
                return false;
        }
        return true;
    }
    static boolean sameCharacter(String s){
        HashSet<Character> hs=new HashSet<>();
        for(char x:s.toCharArray())
            hs.add(x);
        if(hs.size()>1)
            return false;
        return true;
    }
}

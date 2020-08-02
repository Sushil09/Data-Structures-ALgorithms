package Questions.Recursion_And_BackTracking_4;

import java.util.ArrayList;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s="aabaab";
        ArrayList<ArrayList<String>> ans= new ArrayList<>();
        generatePalinString(s,0,s.length(),new ArrayList<String>(),ans);
        for(ArrayList al:ans){
            for(Object x:al)
                System.out.print((String) x+"|");
            System.out.println();

        }
    }
    static void generatePalinString(String s,int idx,int N,ArrayList<String> al,ArrayList<ArrayList<String>> ans){
        if(idx==N){
            ans.add(new ArrayList<>(al));
            return;
        }
        for(int i=idx;i<N;i++){
            if(isPalindrome(s,idx,i)){
                al.add(s.substring(idx,i+1));
                generatePalinString(s,i+1,N,al,ans);
                al.remove(al.size()-1);
            }
        }
    }
    static boolean isPalindrome(String s,int start,int end){
        while (start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}

//Complexity-O(N* 2^N) can be optimized to O(N^3 + 2^N)
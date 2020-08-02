package Questions.Recursion_And_BackTracking_4;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSetLexSort {
    public static void main(String[] args) {
        int[]a={1,2,3};
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        subSetInorder(a,ans);
        for(ArrayList<Integer> al:ans){
            for(int x:al)
                System.out.print(x+" ");
            System.out.println();
        }
    }
    static void subSetInorder(int[]a,ArrayList<ArrayList<Integer>> ans){
        Arrays.sort(a);
        ans.add(new ArrayList<>());
        for(int i=0;i<a.length;i++){
            ArrayList<Integer> al=new ArrayList<>();
            al.add(a[i]);
            recSort(a,ans,i+1,al);
        }
    }
    static void recSort(int[]a,ArrayList<ArrayList<Integer>> ans,int cirrInd,ArrayList<Integer> currSet){
        ans.add(currSet);
        for(int i=cirrInd;i<a.length;i++){
            ArrayList<Integer> al=new ArrayList<>(currSet);
            al.add(a[i]);
            recSort(a,ans,i+1,al);
        }
    }
}

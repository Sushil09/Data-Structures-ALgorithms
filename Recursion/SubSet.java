package Questions.Recursion_And_BackTracking_4;

import java.util.ArrayList;

public class SubSet {
    public static void main(String[] args) {
        int[]a={1,2,3};
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        genSubset(a,a.length,0,ans,new ArrayList<>());
        for(ArrayList<Integer> al:ans) {
            for (int x : al)
                System.out.print(x + " ");
            System.out.println();
        }
    }
    static void genSubset(int[]a,int N,int idx,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> al){
        if(idx==N){
            ans.add(al);
            return;
        }
        ArrayList<Integer> al_temp=new ArrayList<>(al);
        al_temp.add(a[idx]);
        genSubset(a,N,idx+1,ans,al_temp);
        genSubset(a,N,idx+1,ans,al);
    }
}

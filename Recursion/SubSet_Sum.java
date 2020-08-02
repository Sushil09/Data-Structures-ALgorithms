package Questions.Recursion_And_BackTracking_4;

import java.util.ArrayList;

public class SubSet_Sum {
    public static void main(String[] args) {
        int[]a={1,2};
        int K=6;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        populateSubsetSum(a,K,0,0,ans,new ArrayList<>());//array,sum,initial_sum,global 2d list,temp list
        for(ArrayList<Integer> al:ans) {
            for (int x : al)
                System.out.print(x + " ");
            System.out.println();
        }
    }
    static void populateSubsetSum(int[]a,int K,int runSum,int idx,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> al){
        if(idx>=a.length || runSum>K)
            return;
        if(runSum==K){
            ans.add(new ArrayList<>(al));
            return;
        }
        ArrayList<Integer> temp=new ArrayList<>(al);
        temp.add(a[idx]);
        populateSubsetSum(a,K,runSum+a[idx],idx,ans,temp);//when repitions of elements are allowed
        populateSubsetSum(a,K,runSum,idx+1,ans,al);
    }
}

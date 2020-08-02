package Questions.Recursion_And_BackTracking_4;

import java.util.ArrayList;

public class SubSetLessThanK {
    public static void main(String[] args) {
        int[]a={20,2,18,9,11,30};
        int K=20;
        int B=2;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        populateSum(a,0,a.length,B,0,new ArrayList<>(),K,ans);
        for(ArrayList<Integer> al:ans){
            for(int x:al)
                System.out.print(x+" ");
            System.out.println();
        }
    }
    static void populateSum(int[]a,int idx,int N,int B,int currSum,ArrayList<Integer> al,int K,ArrayList<ArrayList<Integer>> ans){
        if(al.size()>B || currSum>K || idx==N)
            return;
        if(al.size()==B){
            int sum=0;
            for(int x:al)
                sum+=x;
            if(sum<=K) {
                ans.add(al);
                return;
            }
            else
                return;
        }
        ArrayList<Integer> al_new =new ArrayList<>(al);
        al_new.add(a[idx]);
        populateSum(a,idx+1,N,B,currSum+a[idx],al_new,K,ans);
        populateSum(a,idx+1,N,B,currSum,al,K,ans);
    }

}

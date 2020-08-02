package Questions.Recursion_And_BackTracking_4;

import java.util.ArrayList;
public class GenPermutations {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>();
        A.add(1);A.add(2);A.add(3);
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        permutations(A,ans,0);
        for(ArrayList<Integer> a:ans)
            System.out.println(a);
    }
    static void permutations(ArrayList<Integer> A,ArrayList<ArrayList<Integer>> ans,int i){
        if(i==A.size()-1){
            ans.add(new ArrayList<>(A));
            return;
        }
        for(int j=i;j<A.size();j++){
            rightRotate(A,i,j);
            permutations(A,ans,i+1);
            leftRotate(A,i,j);
        }
    }
    static void rightRotate(ArrayList<Integer> A,int i,int j){
        int temp=A.get(j);
        for(int x=j;x>i;x--)
            A.set(x,A.get(x-1));
        A.set(i,temp);
    }
    static void leftRotate(ArrayList<Integer> A,int i,int j){
        int temp=A.get(i);
        for(int x=i+1;x<=j;x++)
            A.set(x-1,A.get(x));
        A.set(j,temp);
    }
}

package Questions.Maths_And_Arrays_1;

import java.util.*;

public class Sweer_Dishes {
    static boolean [] sieves;
    public static void main(String[] args) {
        int[]a={2,2,4,5};
        int max_ele=findMax(a);
        sieves=new boolean[max_ele+1];
        Arrays.fill(sieves,true);
        sieves[0]=sieves[1]=true;
        fiilSieves(sieves);
        int B=3,C=7;
        ArrayList<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        generteSubsets(a,temp,res,0);
        int count=0;
        for(List<Integer> al:res) {
            for(int x:al)
                System.out.print(x+" ");
            System.out.println();
        }
        System.out.println("Ans:");

        for(List<Integer> al:res) {
            int flag=0;
            long sum=0;
            for(int i=0;i<al.size();i++){
                if(sieves[al.get(i)])
                    flag=1;
                sum+=(long)al.get(i);
            }
            if(flag==1 && sum>=B && sum<=C)
                count++;
        }
        System.out.println(count);
    }
    static int findMax(int[]a){
        int max_ele=a[0];
        for(int x:a)
            max_ele=Math.max(x,max_ele);
        return max_ele;
    }
    static void generteSubsets(int[]a,List<Integer> temp,ArrayList<List<Integer>> res,int idx){
        if(idx>a.length)
            return;
        res.add(temp);
        for(int i=idx;i<a.length;i++){
            List<Integer> t=new ArrayList<>(temp);
            t.add(a[i]);
            generteSubsets(a,t,res,i+1);
            t.remove(t.size());
//            generteSubsets(a,t,res,i+1);
        }
    }
    static void fiilSieves(boolean[]sieves){
        for(int i=2;i<sieves.length;i++){
            if(sieves[i]){
                for(int j=2*i;j<sieves.length;j+=i)
                    sieves[j]=false;
            }
        }
    }
}

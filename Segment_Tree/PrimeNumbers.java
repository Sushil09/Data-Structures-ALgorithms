package Questions.Segment_Tress_13;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeNumbers {
    static boolean[]sieves;
    public static void main(String[] args) {
        sieves=new boolean[(int)(1E6)+1];
        Arrays.fill(sieves,true);
        sieves[0]=false;sieves[1]=false;
        fillPrime(sieves);
        int[]a={7,5,11};
        int[]modA=findPrimeArray(a);
        String[]B = {"C", "A"};
        int[]C = {2,  2};
        int[]D = {9, 3};
        int[]seg=new int[4*a.length];
        buildTree(modA,0,modA.length-1,seg,1);
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<B.length;i++) {
            if (B[i].equals("A"))
                al.add(query(modA, 0, modA.length-1, 1, C[i] - 1, D[i] - 1,seg));
            else {
                if (sieves[D[i]] && modA[C[i] - 1] != 1){
                    modA[C[i] - 1]=1;
                    updateTree(modA, 0, modA.length-1, seg,C[i] - 1,1);
                }
                else if(!sieves[D[i]] && modA[C[i] - 1] == 1){
                    modA[C[i] - 1]=0;
                    updateTree(modA, 0, modA.length-1, seg,C[i] - 1,1);
                }
            }
        }
        int[]ans=new int[al.size()];
        for(int i=0;i<ans.length;i++)
            ans[i]=al.get(i);
        System.out.println(al);
    }
    static int query(int[]a, int start, int end, int idx, int qStart, int qEnd,int []seg) {
        if (start>=qStart && end<=qEnd)
            return seg[idx];
        if(end<qStart || start>qEnd)
            return 0;
        int mid=start+(end-start)/2;
        return query(a,start,mid,2*idx,qStart,qEnd,seg)+query(a,mid+1,end,2*idx+1,qStart,qEnd,seg);
    }
    static void updateTree(int[]a,int low,int high,int[]st,int target,int idx){
        if(low==high) {
            st[idx]=a[target];
            return;
        }
        int mid=low+(high-low)/2;
        if(target<=mid)
            updateTree(a,low,mid,st,target,2*idx);
        else
            updateTree(a,mid+1,high,st,target,2*idx+1);
        st[idx]=st[2*idx]+st[2*idx+1];
    }
    static void buildTree(int[]a,int low,int high,int[]seg,int idx){
        if(low==high){
            seg[idx]=a[low];
            return;
        }
        int mid=low+(high-low)/2;
        buildTree(a,low,mid,seg,2*idx);
        buildTree(a,mid+1,high,seg,2*idx+1);
        seg[idx]=seg[2*idx]+seg[2*idx+1];
    }
    static int[] findPrimeArray(int []x){
        int[]c=new int[x.length];
        for(int i=0;i<c.length;i++){
            if(sieves[x[i]])
                c[i]=1;
        }
        return c;
    }
    static void fillPrime(boolean[]sieves){
       for(int i=2;i<sieves.length;i++){
           if(sieves[i]){
               for(int j=2*i;j<sieves.length;j+=i)
                   sieves[j]=false;
           }
       }
    }

}

package Questions.Heaps_14;

import java.util.Collections;
import java.util.PriorityQueue;

public class ShipCompany {
    public static void main(String[] args) {
        int[]a={2};
        int A=1,B=1;
        int[]ans=findMaxMin(a,A,B);
        for(int x:ans)
            System.out.print(x+" ");
    }
    static int[] findMaxMin(int[]a,int A,int B){
        int[]ans=new int[2];
        int leftMax=A,rightMax=A;
        PriorityQueue<Integer> pqMin=new PriorityQueue<>();
        PriorityQueue<Integer> pqMax=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<a.length;i++){
            pqMax.add(a[i]);
            pqMin.add(a[i]);
        }
//        int ma=0;
        int max=0,min=0;
        while(leftMax-->0 && pqMax.size()>0){
            int x=pqMax.poll();
            max+=x;
            if((x-1)>0)
            pqMax.add(x-1);
        }
        while(rightMax-->0 && pqMin.size()>0){
            int x=pqMin.poll();
            min+=x;
            if((x-1)>0)
            pqMin.add(x-1);
        }
        ans[0]=max;
        ans[1]=min;
        return ans;
    }
}

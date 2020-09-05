package Questions.Heaps_14;

import java.util.Collections;
import java.util.PriorityQueue;

public class Special_Median {
    public static void main(String[] args) {
        int []a={6, 1, 4, 3, 3, 7, 2};
        System.out.println(midCheck(a));
    }
    static int midCheck(int[]a){
        int N=a.length;
        if(N==1)
            return 0;
        PriorityQueue<Integer> pqMin=new PriorityQueue<>();
        PriorityQueue<Integer> pqMax=new PriorityQueue<>(Collections.reverseOrder());
        pqMax.add(a[0]);
        for(int i=1;i<N;i++){
            if((pqMax.size()+pqMin.size())%2==0){
                if((pqMax.peek()+pqMin.peek()%2==0) && (pqMax.peek()+pqMin.peek()) / 2 ==a[i])
                    return 1;
            }
            else if((pqMax.size()+pqMin.size())%2!=0){
                if(pqMax.peek()==a[i])
                    return 1;
            }
            if(pqMax.peek()<=a[i])
                pqMin.add(a[i]);
            else
                pqMax.add(a[i]);
            modifyHeap(pqMax,pqMin);
        }
        pqMin=new PriorityQueue<>();
        pqMax=new PriorityQueue<>(Collections.reverseOrder());
        pqMax.add(a[N-1]);
        for(int i=N-2;i>=0;i--){
            if((pqMax.size()+pqMin.size())%2==0){
                if((pqMax.peek()+pqMin.peek()%2==0) && (pqMax.peek()+pqMin.peek()) / 2 ==a[i])
                    return 1;
            }
            else if((pqMax.size()+pqMin.size())%2!=0){
                if(pqMax.peek()==a[i])
                    return 1;
            }
            if(pqMax.peek()<=a[i])
                pqMin.add(a[i]);
            else
                pqMax.add(a[i]);
            modifyHeap(pqMax,pqMin);
        }
        return 0;
    }
    static void modifyHeap(PriorityQueue<Integer> pqMin,PriorityQueue<Integer> pqMax){
        int limit=pqMax.size()-pqMin.size();
        if(limit>1)
            pqMin.add(pqMax.poll());
        else if(limit<0)
            pqMax.add(pqMin.poll());
    }
}

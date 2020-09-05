package Questions.Heaps_14;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinLargestElement {
    public static void main(String[] args) {
        int[]a={1};
        PriorityQueue<HeapClass> pq=new PriorityQueue<>(new MyComparator());
        int B=0;
        for(int i=0;i<a.length;i++)
            pq.add(new HeapClass(a[i],a[i]));
        System.out.println(maxEle(pq,B));
    }
    static int maxEle(PriorityQueue<HeapClass> pq,int B){
        int ans=Integer.MIN_VALUE;
        while(B-->0){
            HeapClass x=pq.poll();
            pq.add(new HeapClass(x.first+x.second,x.second));
        }
        while(!pq.isEmpty()){
            ans=Math.max(pq.poll().first,ans);
        }
        return ans;
    }
    static class HeapClass{
        int first,second;
        HeapClass(int x,int y){
            this.first=x;
            this.second=y;
        }
    }
    static class MyComparator implements Comparator<HeapClass> {
        public int compare(HeapClass h1, HeapClass h2){
            int first=h1.first+h1.second;
            int second=h2.first+h2.second;
            if(first==second)
                return h1.second-h2.second;
            else
                return first-second;
        }
    }
}


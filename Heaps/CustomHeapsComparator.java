package Questions.Heaps_14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CustomHeapsComparator {
    public static void main(String[] args) {
        int[][]a={{1,3},
                {2,2},
                {4,8},
                {6,9},
                {-3,-3}};
        PriorityQueue<HeapCompare> pq=new PriorityQueue<>(a.length,new myComparator());
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<a.length;i++){
            HeapCompare h=new HeapCompare(a[i][0],a[i][1]);
            pq.add(h);
        }
        int B=3;
        while(B-->0){
            HeapCompare h=pq.poll();
            System.out.println(h.first+" "+h.second +"-->"+h.distance);
            System.out.println();
        }
    }
}
class myComparator implements Comparator<HeapCompare>{
    public int compare(HeapCompare h1,HeapCompare h2){
        return (int)(h1.distance-h2.distance);
    }
}
class HeapCompare{
    int first,second;
    long distance;
    HeapCompare(int first,int second){
        this.first=first;
        this.second=second;
        this.distance=first*first+second*second;
    }
}

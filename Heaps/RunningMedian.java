package Questions.Heaps_14;

import java.util.*;

public class RunningMedian {
    public static void main(String[] args) {
        int[]a={5, 17, 100, 11};
        List<Integer> al=new ArrayList<>();
        populateMedian(a,al);
        for(int x:al)
            System.out.print(x+" ");
        System.out.println();
    }
    static void populateMedian(int[]a, List<Integer> al){
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();//min heap
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());//max heap
        maxHeap.add(a[0]);
        al.add(maxHeap.peek());
        for(int i=1;i<a.length;i++){
            if(a[i]<maxHeap.peek())
                maxHeap.add(a[i]);
            else
                minHeap.add(a[i]);
            int limit=maxHeap.size()-minHeap.size();
            if(limit>=2)
                minHeap.add(maxHeap.poll());
            else if(limit<0)
                maxHeap.add(minHeap.poll());
            al.add(maxHeap.peek());
        }
    }
}

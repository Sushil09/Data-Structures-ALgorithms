package Questions.Heaps_14;

import Questions.Trees_11.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NmaxPairComb {
    static class MyComparator implements Comparator<HeapClass>{
        public int compare(HeapClass h1,HeapClass h2){
            return h2.sum-h1.sum;
        }
    }
    public static void main(String[] args) {
        int[]a={1,2,3,4,5,6};
        int[]b={1,5-1,13,-3,-4,-8};
        Arrays.sort(a);
        Arrays.sort(b);
        ArrayList<Integer> al=new ArrayList<>(a.length);
//        populateAns(a,b,al);
        Integer[]ans= al.toArray(new Integer[0]);
        for(int x:al)
            System.out.print(x+" ");
    }
//    static void populateAns(int[]a,int[]b,ArrayList<Integer> al){
//        int N=a.length;
//        PriorityQueue<HeapClass> pq=new PriorityQueue<>(new MyComparator());
//        pq.add(new HeapClass(a[N-1]+b[N-1],N-1,N-1));
//        int k=0;
//        while(k<N){
//            HeapClass temp=pq.poll();
//            al.add(temp.sum);
//            if(temp.first>0)
//            pq.add(new HeapClass(a[temp.first-1]+b[temp.second],temp.first-1,temp.second));
//            if(temp.second>0)
//            pq.add(new HeapClass(a[temp.first]+b[temp.second-1],temp.first,temp.second-1));
//            k++;
//        }
//    }
}

class HeapClass{
    Pair x;
    int sum;
    HeapClass(int sum,Pair p){
        this.sum=sum;
        this.x=p;
    }
}


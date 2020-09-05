package Questions.Heaps_14;

import Questions.Pair_;
import java.util.*;

public class CandiesBox {
    public static void main(String[] args) {
        int []a={36, 89, 90, 109, 96, 77, 72, 69, 43, 60, 55, 76, 18, 24, 74, 66, 64, 27, 39, 38, 16, 31, 11, 77 };
        Arrays.sort(a);
        for(int i=1;i<a.length;i++)
            System.out.print(a[i]-a[i-1]+" ");
        System.out.println();
        System.out.println(a.length);
        for(int x:a)
            System.out.print(x+" ");
        System.out.println();
        System.out.println(findMin(a));
    }
    static int findMin(int[]a){
        int N=a.length;
        Arrays.sort(a);

        int smallBox=N/2;
        int bigBox=smallBox-1;
        PriorityQueue<HeapCustom> pq=new PriorityQueue<HeapCustom>(new MyComparator());
        for(int i=1;i<N;i++){
            Pair_ temp=new Pair_(i,i-1);
            pq.add(new HeapCustom(temp,a[i]-a[i-1]));
        }
        Set<Integer> hs=new HashSet<>();
        int sum=0;
        for(int i=0;i<bigBox;){
            HeapCustom temp=pq.poll();
//            System.out.print(temp.Diff+" ");
            if(!hs.contains((Integer) temp.p.first) && !hs.contains((Integer)temp.p.second)){
                System.out.print(temp.Diff+" ");
                sum+=temp.Diff;
                hs.add((Integer) temp.p.first);
                hs.add((Integer) temp.p.second);
                i++;
            }
        }
    return sum;
    }
}
class MyComparator implements Comparator<HeapCustom>{
    public int compare(HeapCustom h1,HeapCustom h2){
        return h1.Diff-h2.Diff;
    }
}
class HeapCustom{
    Pair_ p;
    int Diff;
    HeapCustom(Pair_ p,int diff){
        this.p=p;
        this.Diff=diff;
    }
}

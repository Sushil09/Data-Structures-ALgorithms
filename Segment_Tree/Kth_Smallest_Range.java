package Questions.Segment_Tress_13;

import java.util.*;
import java.util.ArrayList;

public class Kth_Smallest_Range {
    public static void main(String[] args) {
        int[]a={23, -12, -16, 1, 9, 2};
        List<pair> al=new ArrayList<>();
        for(int i=0;i<a.length;i++)
            al.add(new pair(a[i],i));
        Collections.sort(al,new myComparator());
        ArrayList [] seg=new ArrayList[4*a.length];
        buildSegTree(al,0,a.length-1,1,seg);


    }
    static void  buildSegTree(List<pair> al,int low, int high,int idx,ArrayList [] seg){
        if(low==high){
            seg[idx].add(al.get(low).y);
            return;
        }
        int mid=low+(high-low)/2;
        buildSegTree(al,low,mid,2*idx,seg);
        buildSegTree(al,mid+1,high,2*idx+1,seg);

        seg[idx].addAll(seg[2*idx]);
        seg[idx].addAll(seg[2*idx+1]);
    }
}
class pair{
    int x, y;
    pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class myComparator implements Comparator{
    public int compare(Object o1,Object o2){
        pair p1=(pair)o1;
        pair p2=(pair)o2;
        return p1.x-p2.x;
    }
}

package Questions.Segment_Tress_13;

import java.util.ArrayList;

public class Special_Sums {
    public static void main(String[] args) {
        int[]a1={4, 8, 5, 10, 3, 8 };
        int[]a2=new int[a1.length];
        for(int i=0;i<a1.length;i++)
            a2[i]=a1[i]*(i+1);
        int[] seg1=new int[a1.length*4];
        int[] seg2=new int[a2.length*4];
        buildFirstSeg(a1,seg1,0,a1.length-1,1);
        buildSecondSeg(a2,seg2,0,a2.length-1,1);
        ArrayList<Integer> al=new ArrayList<>();
        int[][]b={ {1, 2, 1},
                  {1, 5, 8},
//                  {2, 1, 2},
                  {2, 4, 4}
//                  ,
//                  {2, 3, 6},
//                  {2, 2, 6},
                 };
        for(int i=0;i<b.length;i++){
            if(b[i][0]==2){
                int first=queriesRange(a1,seg1,0,a1.length-1,1,b[i][1]-1,b[i][2]-1);
                int second=queriesRange(a2,seg2,0,a2.length-1,1,b[i][1]-1,b[i][2]-1);
                int result=second-(b[i][1]-1)*first;
                System.out.println(first);
                System.out.println(second);
                al.add(result);
            }
            else {
                a1[b[i][1]-1]=b[i][2];
                a2[b[i][1]-1]=b[i][2]*b[i][1];
                updateSegmentTree(seg1,a1,0,a1.length-1,1,b[i][1]-1);
                updateSegmentTree(seg2,a2,0,a2.length-1,1,b[i][1]-1);
            }
        }

        for (int x:seg1)
            System.out.print(x+" ");
        System.out.println();
        for (int x:seg2)
            System.out.print(x+" ");


    }

    static void updateSegmentTree(int[]seg,int[]a,int low,int high,int idx,int target){
        if(low==high){
            seg[idx]=a[target];
            return;
        }
        else{
            int mid=low+(high-low)/2;
            if(target<=mid)
                updateSegmentTree(seg,a,low,mid,2*idx,target);
            else
                updateSegmentTree(seg,a,mid+1,high,2*idx+1,target);
            seg[idx]=seg[2*idx]+seg[2*idx+1];
        }
    }

    private static void buildSecondSeg(int[] a, int[] seg, int low, int high, int idx) {
        if(low==high){
            seg[idx]=a[low];
            return;
        }
        else {
            int mid=low+(high-low)/2;
            buildFirstSeg(a,seg,low,mid,2*idx);
            buildFirstSeg(a,seg,mid+1,high,2*idx+1);
            seg[idx]=seg[2*idx]+seg[2*idx+1];
        }
    }

    private static void buildFirstSeg(int[]a,int[]seg,int low,int high,int idx){
        if(low==high) {
            seg[idx] = a[low];
            return;
        }
        else {
            int mid=low+(high-low)/2;
            buildFirstSeg(a,seg,low,mid,2*idx);
            buildFirstSeg(a,seg,mid+1,high,2*idx+1);
            seg[idx]=seg[2*idx]+seg[2*idx+1];
        }
    }
    static int queriesRange(int[]a,int[] st, int start, int end, int idx, int qStart, int qEnd) {
        if (start>=qStart && end<=qEnd)
            return st[idx];
        if(end<qStart || start>qEnd)
            return 0;
        int mid=start+(end-start)/2;
        return queriesRange(a,st,start,mid,2*idx,qStart,qEnd)+queriesRange(a,st,mid+1,end,2*idx+1,qStart,qEnd);
    }

}

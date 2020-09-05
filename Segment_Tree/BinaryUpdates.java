package Questions.Segment_Tress_13;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class BinaryUpdates {
    public static void main(String[] args) {
        int[]a={1,1,1,1,1,1,1,1,1,1,1,1,1};
        int[][]b={{0, 7},
                  {1, 8},
                  {0, 5},
                  {0, 12},
                  {1, 1},
                  {1, 6},
                  {1, 11},
                  {1, 9},
                  {1, 3}};
        int[]seg=new int[4*a.length];
        buildSegmentTree(a,seg,0,a.length-1,1);
        for(int x:seg)
            System.out.print(x);
        System.out.println();
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<b.length;i++){
            if(b[i][0]==0){
                a[b[i][1]-1]=0;
                updateSegmentTree(seg,a,0,a.length-1,1,b[i][1]-1);
            }
            else{
                if(b[i][1]>seg[1])
                    al.add(-1);
                else
                al.add(getSegValue(seg,a,0,a.length-1,1,b[i][1])+1);
            }
        }
        int[]ans=new int[al.size()];
        for(int i=0;i<ans.length;i++)
            ans[i]=al.get(i);

        for(int x:ans)
            System.out.print(x);
    }
    static void buildSegmentTree(int[] a, int[] st, int start, int end, int idx) {
        if (start == end)
            st[idx] = a[start];
        else {
            int mid = start + (end - start) / 2;
            buildSegmentTree(a, st, start, mid, 2 * idx);
            buildSegmentTree(a, st, mid + 1, end, 2 * idx + 1);
            st[idx] =st[2 * idx]+st[2 * idx + 1];
        }
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
    static int getSegValue(int[]seg,int []a,int low,int high,int idx,int target){
        if(low==high)
                return low;
        else{
            int mid=low+(high-low)/2;
            int leftSide=seg[2*idx];
            if(leftSide>=target){
                return getSegValue(seg,a,low,mid,2*idx,target);
            }
            else
                return getSegValue(seg,a,mid+1,high,2*idx+1,target-leftSide);
        }
    }
}

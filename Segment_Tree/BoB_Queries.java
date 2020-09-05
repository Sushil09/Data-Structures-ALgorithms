package Questions.Segment_Tress_13;
import java.util.ArrayList;

public class BoB_Queries {
    public static void main(String[] args) {
        int []a={0,0,0,0,0,0,0,0};
        int[]st=new int[2*a.length];
        int [][]b={{1, 1, -1},
        {1, 2, -1},
        {1, 3, -1},
        {3, 1, 3},
        {3, 2, 4}
        };
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<b.length;i++){
            if(b[i][0]==1) {
                a[b[i][1]-1]++;
                updateSegTree(a, 0, a.length - 1, st, b[i][1]-1, 1);
            }
            if(b[i][0]==2) {
                a[b[i][1]-1]=Math.max(0,--a[b[i][1]-1]);
                updateSegTree(a, 0, a.length - 1, st, b[i][1]-1, 1);
            }
            if(b[i][0]==3)
                al.add(queriesRange(a,st,0,a.length-1,1,b[i][1]-1,b[i][2]-1));
        }
        System.out.println(al);
    }
    static void updateSegTree(int[]a,int low,int high,int[]st,int target,int idx){
        if(low==high) {
            st[idx]=a[target];
            return;
        }
        int mid=low+(high-low)/2;
        if(target<=mid)
            updateSegTree(a,low,mid,st,target,2*idx);
        else
            updateSegTree(a,mid+1,high,st,target,2*idx+1);
        st[idx]=st[2*idx]+st[2*idx+1];
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


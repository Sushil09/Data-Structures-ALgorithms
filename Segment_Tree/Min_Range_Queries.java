package Questions.Segment_Tress_13;

import java.io.*;

public class Min_Range_Queries {
    public static void main(String[] args) throws IOException {
        int[] a = {5, 3, 4, 10, 2, 9, 12, 7};
        int[] st = new int[4 * a.length];
        st[0] = Integer.MAX_VALUE;
        buildSegmentTree(a, st, 0, a.length - 1, 1);
            System.out.print(queriesRange(a,st, 0, a.length - 1, 1, 0, 4));
            System.out.println();
    }
    static void buildSegmentTree(int[] a, int[] st, int start, int end, int idx) {
        if (start == end)
            st[idx] = a[start];
        else {
            int mid = start + (end - start) / 2;
            buildSegmentTree(a, st, start, mid, 2 * idx);
            buildSegmentTree(a, st, mid + 1, end, 2 * idx + 1);
            st[idx] = Math.min(st[2 * idx], st[2 * idx + 1]);
        }
    }
    static int queriesRange(int[]a,int[] st, int start, int end, int idx, int qStart, int qEnd) {
        if (start>=qStart && end<=qEnd)
            return st[idx];
        if(end<qStart || start>qEnd)
            return Integer.MAX_VALUE;
            int mid=start+(end-start)/2;
            return Math.min(queriesRange(a,st,start,mid,2*idx,qStart,qEnd),queriesRange(a,st,mid+1,end,2*idx+1,qStart,qEnd));
    }
}


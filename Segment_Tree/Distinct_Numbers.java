package Questions.Segment_Tress_13;

import java.util.HashSet;

public class Distinct_Numbers {
    public static void main(String[] args) {
        int []a={2, 3, 4, 2, 1};
        DistinctElements dl=new DistinctElements(a.length);
        dl.init();
        dl.buildSegment(a,0,a.length-1,1);
        System.out.println(dl.query(a,0,a.length-1,0,4,1).size());
    }
}
class DistinctElements{
    HashSet[] hs;
    int n;
    public DistinctElements(int n){
        this.n=n;
        hs=new HashSet[4*n];
    }
    public void init(){
        for(int i=0;i<4*n;i++){
            hs[i]=new HashSet<>();
        }
    }
    public void buildSegment(int[]a,int low,int high,int idx){
        if(low==high){
            hs[idx].add(a[low]);
            return;
        }
        int mid=low+(high-low)/2;
        buildSegment(a,low,mid,2*idx);
        buildSegment(a,mid+1,high,2*idx+1);
        hs[idx].addAll(hs[2*idx]);
        hs[idx].addAll(hs[2*idx+1]);
    }
    public HashSet query(int[]a,int low,int high,int qL,int qH,int idx){
        HashSet<Integer> result=new HashSet<>();
        if(qL<=low && qH>=high)
            return hs[idx];
        if(high<qL || low>qH)
            return result;
        int mid=low+(high-low)/2;
        HashSet leftSide=query(a,low,mid,qL,qH,2*idx);
        HashSet rightSide=query(a,mid+1,high,qL,qH,2*idx+1);
        result.addAll(leftSide);
        result.addAll(rightSide);
        return result;
    }

}
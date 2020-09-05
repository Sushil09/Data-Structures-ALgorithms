package Questions.DP_15;

import java.util.TreeSet;

public class LongestFibSubsequence {
    public static void main(String[] args) {
        int[]a={1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(maxFibSeq(a));
    }
    static int maxFibSeq(int[]a){
        TreeSet<Integer> s=new TreeSet<>();
        int maxLength=0;
        for(int x:a)
            s.add(x);
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                int x=a[j],y=a[i]+a[j],len=2;
                while(s.contains(y) ){
                    int z=y;
                    y+=x;x=z;
                    maxLength=Math.max(maxLength,++len);
                }
            }
        }
        return maxLength;
    }
}

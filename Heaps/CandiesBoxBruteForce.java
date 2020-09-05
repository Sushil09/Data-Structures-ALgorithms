package Questions.Heaps_14;

import java.util.ArrayList;
import java.util.Collections;

public class CandiesBoxBruteForce {
    public static void main(String[] args) {
        int[]a={2, 4, 1, 10, 6, 15};
        ArrayList<Integer> al=new ArrayList<>(a.length);
        for(int x:a)
            al.add(x);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                if(i!=j){
                    ArrayList<Integer> alTemp=new ArrayList<>();
                    for(int k=0;k<a.length;k++){
                        if(k==i || k==j )
                            continue;
                        else
                            alTemp.add(a[k]);
                    }
                    ans=Math.min(ans,solver(alTemp));
                }

            }
        }
        System.out.println(ans);
    }
    static int solver(ArrayList<Integer> al){
        Collections.sort(al);
        int sum=0;
        for(int i=1;i<al.size();i+=2)
            sum+=al.get(i)-al.get(i-1);
        return sum;
    }
}

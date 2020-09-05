package Questions.Heaps_14;

import java.util.ArrayList;

public class Seats {
    static int MOD=(int)(1E7+3);
    public static void main(String[] args) {
        String s="....xxx";
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='x')
                al.add(i);
        System.out.println(MinimizedMovement(al));
    }
    static int MinimizedMovement(ArrayList<Integer> al){
        int N=al.size();
        int mid=N/2;
        int ans=0,k=1;
        for(int i=mid-1;i>=0;i--){
            ans=(ans+al.get(mid)-al.get(i)-k)%MOD;
            k++;
        }
        k=1;
        for(int i=mid+1;i<N;i++){
            ans=(ans+al.get(i)-(al.get(mid)+k))%MOD;
            k++;
        }
        return ans;
    }
}

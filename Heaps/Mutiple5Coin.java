package Questions.Heaps_14;

import java.util.ArrayList;
import java.util.List;

public class Mutiple5Coin {
    public static void main(String[] args) {
        int A=9;
        System.out.println(coinsNeeded(A));
    }
    static int coinsNeeded(int A){
        List<Integer> al=new ArrayList<>();
        int x=1;
        al.add(1);
        while (x<=A){
            x*=5;
            if(x<=A)
                al.add(x);
        }
        int coins=0;
        for(int i=al.size()-1;i>=0;i--){
            int perCoin=A/al.get(i);
            coins+=perCoin;
            A=A-(al.get(i)*perCoin);
            if(A==0)
                break;
        }
        return coins;
    }
}

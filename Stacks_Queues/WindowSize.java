package Questions.Stacks_And_Queues_9;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class WindowSize {
    public static void main(String[] args) {
        int[]a={-1, 2, 3, -4, 5};
        int K=2;
        ArrayList<Integer> ans=new ArrayList<>();
        populateList(ans,a,K);
        for(int x:ans)
            System.out.print(x+" ");
    }
    static void populateList(ArrayList<Integer> ans,int[]a,int K){
        Deque<Integer> deque=new LinkedList<>();
        initializeDeque(deque,a,K);
        if(deque.size()>0)
            ans.add(a[deque.peekFirst()]);
        else
            ans.add(0);
        for(int i=K;i<a.length;i++){
            if(a[i]<0)
                deque.addLast(i);
            while(deque.size()>0 && deque.peekFirst()<=(i-K))
                deque.removeFirst();
                if(deque.size()>0)
                    ans.add(a[deque.peekFirst()]);
                else
                    ans.add(0);
        }
    }
    static void initializeDeque(Deque<Integer> deque,int[]a,int K){
        for(int i=0;i<K;i++)
            if(a[i]<0)
                deque.addLast(i);
    }
}

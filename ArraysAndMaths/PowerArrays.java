
import java.util.Stack;

public class PowerArrays {
    public static void main(String[] args) {
//        int[]a={1, 2, 3, 4, 5};
        int[]a={64};
        int[]pg=new int[a.length];
        int[] ng=new int[a.length];
        populatepg(a,pg);
        populateng(a,ng);
        int ans=0;
        for(int i=0;i<a.length;i++){
            ans+=ng[i]-i-1;
            ans+=i-pg[i]-1;
            ans+=(ng[i]-i-1)*(i-pg[i]-1);
        }
        for(int x:pg)
            System.out.print(x+" ");
        System.out.println();
        for(int x:ng)
            System.out.print(x+" ");
        System.out.println();
        System.out.println(ans);
    }
    static void populatepg(int[]a,int[]pg){
        Stack<Integer> s=new Stack<>();
        s.push(0);
        pg[0]=-1;
        for(int i=1;i<a.length;i++){
            while (!s.isEmpty() && a[i]/2>=a[s.peek()])
                s.pop();
            if(s.isEmpty())
                pg[i]=-1;
            else
                pg[i]=s.peek();
            s.push(i);
        }
    }
    static void populateng(int[]a,int[]ng){
        int N=a.length;
        Stack<Integer> s=new Stack<>();
        s.push(N-1);
        ng[N-1]=N;
        for(int i=N-2;i>=0;i--){
            while (!s.isEmpty() && a[i]/2>=a[s.peek()])
                s.pop();
            if(s.isEmpty())
                ng[i]=N;
            else
                ng[i]=s.peek();
            s.push(i);
        }
    }
}

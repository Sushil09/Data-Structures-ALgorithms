package Questions.Stacks_And_Queues_9;

import java.util.Arrays;
import java.util.Stack;

public class Min_Values {
    public static void main(String[] args) {
        int[]a={7,5,7,9,8,7};
        largestRectangleArea(a);
    }
    public static void largestRectangleArea(int[] a) {
        int size=a.length;
        int[] p1=new int[size];
        int[] p2=new int[size];
        Stack<Integer> s1=new Stack<Integer>();
        for(int i=1;i<a.length;i++) {
            while(!s1.isEmpty() && a[i]>=a[s1.peek()])
                s1.pop();
            if(s1.size()==0)
                p1[i]=0;
            else
                p1[i]=s1.peek();
            s1.push(i);
        }
        s1=new Stack<>();
        s1.push(size-1);
        for(int i=size-2;i>=0;i--) {
            while(!s1.isEmpty() && a[i]>=a[s1.peek()])
                s1.pop();
            if(s1.size()==0)
                p2[i]=0;
            else
                p2[i]=s1.peek();
            s1.push(i);
        }
        for(int x:p1)
            System.out.print(x+" ");
        System.out.println();
        for(int x:p2)
            System.out.print(x+" ");
        }




}

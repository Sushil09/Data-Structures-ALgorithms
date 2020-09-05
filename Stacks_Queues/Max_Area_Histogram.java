package Questions.Stacks_And_Queues_9;

import java.util.Arrays;
import java.util.Stack;

public class Max_Area_Histogram {
    public static void main(String[] args) {
        int[]a={2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(a));
    }
    public static int largestRectangleArea(int[] a) {
        int size=a.length;
        int[] p1=new int[size];
        int[] p2=new int[size];
        Arrays.fill(p1, -1);
        Arrays.fill(p2, size);
        Stack<Integer> s1=new Stack<Integer>();
        for(int i=0;i<a.length;i++) {
            while(!s1.isEmpty() && a[i]<a[s1.peek()])
            {
                int x=s1.peek();
                s1.pop();
                p2[x]=i;
            }
            s1.push(i);
        }
        for(int x:p2)
            System.out.print(x+" ");
        System.out.println();
        s1=null;
        Stack<Integer> s2=new Stack<Integer>();
        for(int i=0;i<a.length;i++) {
            while(!s2.isEmpty() && a[i]<a[s2.peek()])
                s2.pop();
            if(!s2.isEmpty())
                p1[i]=s2.peek();
            s2.push(i);
        }
        int area=0;
        for(int i=0;i<size;i++) {
            area=Math.max(area, (p2[i]-p1[i]-1)*a[i]);
        }
        for(int x:p1)
            System.out.print(x+" ");
        System.out.println();
        return area;
    }

}

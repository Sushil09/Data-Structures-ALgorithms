package Questions.Stacks;

import java.util.Stack;

public class Max_Xor_Pairs {
    public static void main(String[] args) {
        int[] a={5,2,1,4,3};
        System.out.println(max_xor(a));
    }
    private static int max_xor(int[] a) {
        Stack<Integer> st=new Stack<>();
        int max_ans=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            while(!st.isEmpty() && a[i]<st.peek()){
                int x=st.pop();
                max_ans=Math.max(max_ans,a[i]^x);
            }
            st.push(a[i]);
        }
        return max_ans;
    }

}

package Questions.Stacks_And_Queues_9;

import java.util.Stack;

public class LongestValidParenthesis {
    public static void main(String[] args) {
        String s="()(()))))";
        System.out.println(longestValid(s));
    }
    static int longestValid(String s){
        int c=0;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && s.charAt(i)==')'){
                if(st.peek()=='('){
                    c+=2;
                    st.pop();
                }
                else
                    st.push(s.charAt(i));
            }
            else
                st.push(s.charAt(i));
        }
        return c;
    }
}

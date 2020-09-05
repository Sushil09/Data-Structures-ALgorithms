package Questions.Stacks_And_Queues_9;

import java.util.Stack;

public class RedundantBraces {
    public static void main(String[] args) {
        String A="(a+(a+b))";
        System.out.println(isRedundant(A.toCharArray()));
    }
    static boolean isRedundant(char[]c){
        Stack<Character> st=new Stack<>();
        boolean flag=false;
        for(char x:c){
            if(!st.isEmpty()&& x==')'){
                char t=st.pop();
                flag=true;
                while (!st.isEmpty() && t!='('){
                    if(t=='*' ||t=='/' || t=='-' || t=='+')
                        flag=false;
                    t=st.pop();
                }
                if (flag)
                    return flag;
            }
            else
                st.push(x);
        }
        return flag;
    }
}

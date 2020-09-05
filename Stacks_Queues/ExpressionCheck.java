package Questions.Stacks;

import java.util.Stack;

public class ExpressionCheck {
    public static void main(String[] args) {
        String A="-(a+b+c)";
        String B="-a-b-c";
        String C=modify(A);
        String D=modify(B);
        System.out.println(C.equals(D));
    }
    static String modify(String x){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<x.length();i++){
            char w=x.charAt(i);
            if(w!='(')
                st.push(w);
            else{
                int j=i+1;
                boolean flag=false;
                if(!st.isEmpty())
                    flag=st.peek()=='-'?true:false;
                while(j<x.length() && x.charAt(j)!=')'){
                    if(x.charAt(j)<='z' && x.charAt(j)>='a')
                        st.push(x.charAt(j));
                    else{
                        if(flag){
                            if(x.charAt(j)=='+')
                                st.push('-');
                            else
                                st.push('+');
                        }
                        else
                            st.push(x.charAt(j));
                    }
                    j++;
                }
                i=j;
            }
        }
        StringBuffer sb=new StringBuffer();
        while(!st.isEmpty()){
            sb.append(String.valueOf(st.pop()));
        }
        return sb.toString();
    }


}

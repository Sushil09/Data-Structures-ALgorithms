package Questions.Stacks;

import java.util.Stack;

public class KthChar {
    public static void main(String[] args) {
        String a="tu16mj75s";
        System.out.println(decrypt(a,56));
    }
    static char decrypt(String s,int k){
        Stack<Pair> st=new Stack<>();
        int l=0;
        for(int i=0;i<s.length()&&l<=k;i++){
            if(!isNumeric(s.charAt(i))){
                l++;
                st.push(new Pair(s.charAt(i),l));
            }
            else{
                StringBuffer sb=new StringBuffer();
                while(isNumeric(s.charAt(i)) && i<s.length()){
                    sb.append(String.valueOf(s.charAt(i)));
                    i++;
                }
                i--;
                int x=Integer.parseInt(sb.toString());
                l=l*x;
            }
        }
        while(!st.isEmpty()){
            Pair x=st.pop();
            char x1=x.a;
            int y1=x.b;
            k=k%y1;
            if(k==0)
                return x1;
            if(k==1 && st.peek().b==1){
                Pair f=st.peek();
                return f.a;
            }
        }
        return 'a';
    }
    static boolean isNumeric(char x){
        if(x>='a' && x<='z')
            return false;
        return true;
    }
    static class Pair{
        char a;
        int  b;
        Pair(char x,int y){
            this.a=x;
            this.b=y;
        }
    }
}

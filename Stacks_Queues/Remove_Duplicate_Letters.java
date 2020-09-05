package Questions.Stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Remove_Duplicate_Letters {
    public static void main(String[] args) {
        String x="cbacdcbc";
        System.out.println(solve(x));
    }
    public static String solve(String A) {
        Map<Character,Integer> hm=new HashMap<>();
        boolean[]visited=new boolean[26];
        Arrays.fill(visited,false);
        Stack<Character> st=new Stack<>();
        for(char x:A.toCharArray())
            hm.put(x,hm.getOrDefault(x,0)+1);
        for(char x: A.toCharArray()){
            hm.put(x,hm.get(x)-1);
            while(!st.isEmpty() && st.peek()>x && hm.get(st.peek())>0){
                visited[st.peek()-'a']=false;
                st.pop();
            }
            if(!visited[x-'a'])
            {
                st.push(x);
                visited[x-'a']=true;
            }
        }
        StringBuffer sb=new StringBuffer();
        while(!st.isEmpty())
            sb.append(String.valueOf(st.pop()));
        return sb.reverse().toString();
    }
}

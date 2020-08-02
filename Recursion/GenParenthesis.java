package Questions.Recursion_And_BackTracking_4;

import java.util.ArrayList;
import java.util.List;

public class GenParenthesis {
    public static void main(String[] args) {
        int N=3;
        List<String> ans=new ArrayList<>();
        char[]c=new char[2*N];
        populateparenthesis(ans,2*N,c,0,0,0);
        for(String x:ans)
            System.out.println(x);
    }
    static void populateparenthesis(List<String> ans,int maxSize,char[]c,int i,int op,int cl){
        if(op+cl==maxSize){
            ans.add(new String(c));
            return;
        }
        if(op<maxSize/2){
            c[i]='(';
            populateparenthesis(ans,maxSize,c,i+1,op+1,cl);
        }
        if(op>cl){
            c[i]=')';
            populateparenthesis(ans,maxSize,c,i+1,op,cl+1);;
        }
    }
}


package Questions.Tries_12;

import java.util.ArrayList;
import java.util.List;

public class Modified_Search {
    public static void main(String[] args) {
        List<String> dictionary=new ArrayList<>();
        dictionary.add("doll");dictionary.add("nata");
        List<String> items=new ArrayList<>();
        items.add("data");
        DictionaryTrie root=new DictionaryTrie();
        buildTrie(root,dictionary);
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<items.size();i++){
            if(query(root,0,items.get(i),0,false))
                sb.append("1");
            else
                sb.append("0");
        }
        System.out.println(sb);
    }
    static boolean query(DictionaryTrie root,int i,String s,int flag,boolean EOW){
        boolean ans=false;
        if(i==s.length()){
            if(flag==1 && EOW)
                return true;
            return false;
        }
        int idx=s.charAt(i)-'a';
        if(flag==0){
                if(root.tri[idx]!=null)
                        ans=ans| query(root.tri[idx],i+1,s,flag,root.tri[idx].EOW);
                    else {
                    for (int j = 0; j < 26; j++) {
                        if (root.tri[j] != null)
                            ans = ans | query(root.tri[j], i + 1, s, 1 - flag, root.tri[j].EOW);
                    }
                }
                }
        else {
            if (root.tri[idx] == null)
                return false;
            else
                ans = ans | query(root.tri[idx], i + 1, s, flag, root.tri[idx].EOW);
        }
            return ans;
    }
    static void buildTrie(DictionaryTrie root,List<String> l){
        if(root==null)
            return;
        for(int i=0;i<l.size();i++){
            DictionaryTrie temp=root;
            for(int j=0;j<l.get(i).length();j++){
                int idx=l.get(i).charAt(j)-'a';
                if(temp.tri[idx]==null)
                    temp.tri[idx]=new DictionaryTrie();
                temp=temp.tri[idx];
            }
            temp.EOW=true;
        }
    }
}

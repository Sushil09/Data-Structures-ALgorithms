package Questions.Tries_12;

import java.util.ArrayList;

class Trie_Word{
    int count;//count of words with this at prefix
    Trie_Word [] trie;
    Trie_Word(){
        count=0;
        trie=new Trie_Word[26];
    }
}
public class Prefix_Word {
    public static void main(String[] args) {
        ArrayList<String> s=new ArrayList<>();
        ArrayList<String> prefix=new ArrayList<>();
        s.add("zebra");
        s.add("dog");
        s.add("duck");
        s.add("dove");
        Trie_Word root=new Trie_Word();
        insert(root,s);
        for(int i=0;i<s.size();i++){
            prefix.add(findPrefix(root,s.get(i)));
        }
        System.out.println(prefix);
    }
    static void insert(Trie_Word root,ArrayList<String> s){
        for (int i=0;i<s.size();i++){
            Trie_Word temp=root;
            String x=s.get(i);
            for(int j=0;j<x.length();j++){
                if(temp.trie[x.charAt(j)-'a']==null){
                    temp.trie[x.charAt(j)-'a']=new Trie_Word();
                }
                temp=temp.trie[x.charAt(j)-'a'];
                temp.count++;
            }
        }
    }
    static String findPrefix(Trie_Word root,String s){
        StringBuffer sb=new StringBuffer();
        Trie_Word t=root;
        for (int i=0;i<s.length();i++){
            int x=s.charAt(i)-'a';
            sb.append(String.valueOf(s.charAt(i)));
            if(t.trie[x].count==1)
                return sb.toString();
            t=t.trie[x];
        }
        return sb.toString();
    }
}


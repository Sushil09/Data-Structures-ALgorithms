package Questions.Tries_12;

import java.util.*;

public class Dictionary_Search {
    public static void main(String[] args) {
        List<String> l=new ArrayList<>();
        l.add("varun");l.add("vishal");l.add("ojha");l.add("sharma");l.add("visha");
        DictionaryTrie root=new DictionaryTrie();
        for(int i=0;i<l.size();i++)
        insert(root,l.get(i));
        System.out.println(search(root,"vishalk"));
    }
    //to insert all values in trie DS
    static void insert(DictionaryTrie root,String s){
      if(root==null)
          return;
        DictionaryTrie temp=root;
      for(int i=0;i<s.length();i++){
          int idx=s.charAt(i)-'a';
          if(temp.tri[idx]==null)
              temp.tri[idx]=new DictionaryTrie();
          temp=temp.tri[idx];
      }
      temp.EOW=true;
    }
    // to search for given string in Trie DS
    static boolean search(DictionaryTrie root,String s){
        if(root==null)
            return false;
        DictionaryTrie temp=root;
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(temp.tri[idx]==null)
                return false;
            temp=temp.tri[idx];
        }
        return temp.EOW;
    }
}
class DictionaryTrie{
    DictionaryTrie[] tri;
    boolean EOW;//EndOfWord
    DictionaryTrie(){
        this.tri=new DictionaryTrie[26];
        EOW=false;
    }
}


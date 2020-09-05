package Questions.Tries_12;
import java.util.ArrayList;

public class Prefix_Suffix {
    public static void main(String[] args) {
        ArrayList<String> A=new ArrayList<>();
        ArrayList<String> B=new ArrayList<>();
        A.add("ababa");A.add("aabbvaab");A.add("aecdsaaec");A.add("abaaxbqaba");
        ArrayList<String> al2=new ArrayList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        B.add("aba");B.add("aec");B.add("abb");B.add("aab");
        Trie_Word root=new Trie_Word();
        int M=3;//count of suffix and prefix
        for (int i=0;i<A.size();i++){
                String s=A.get(i);
            if(M<=s.length()) {
                if (s.substring(0, M).equals(s.substring(s.length() - M, s.length())))
                    al2.add(s);
            }
        }
        createTrie(root,al2);
        for(int i=0;i<B.size();i++)
            ans.add(find_count(root,B.get(i)));
        System.out.println(ans);
    }
    static int find_count(Trie_Word root,String s){
        Trie_Word temp=root;
        for(int i=0;i<s.length();i++){
            int x=s.charAt(i)-'a';
            if(temp.trie[x]==null)
                return 0;
            temp=temp.trie[x];
        }
        return temp.count;
    }
    static void createTrie(Trie_Word root,ArrayList<String> s){
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
}

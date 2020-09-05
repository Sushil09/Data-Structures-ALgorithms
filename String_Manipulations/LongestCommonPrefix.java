package Questions.String_Manipulations;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] s={"abab", "ab", "abcd"};
        Trie_Word root=new Trie_Word();
        makeTrie(s[0],root);
        for(int i=1;i<s.length;i++)
            modifyTrie(root,s[i]);
//        System.out.println(preFix(root));
    }
    static void modifyTrie(Trie_Word root,String s){
        Trie_Word temp=root;
        for(int i=0;i<s.length();i++){
            if(temp.trie[s.charAt(i)]!=null)
                temp=temp.trie[s.charAt(i)-'a'];
            else{
                temp=null;
            }
        }
    }
    static void makeTrie(String s,Trie_Word root){
        Trie_Word temp=root;
        for(int i=0;i<s.length();i++){
            if(temp.trie[s.charAt(i)-'a']==null){
                temp.trie[s.charAt(i)-'a']=new Trie_Word();
                temp=temp.trie[s.charAt(i)-'a'];
            }
        }
    }
}

class Trie_Word{
    Trie_Word[] trie;
    public Trie_Word(){
        trie=new Trie_Word[26];
    }
}


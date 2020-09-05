package Questions.Trees_11;

public class LowestLCA {
    static Node ans=null;
    public static void main(String[] args) {
        Node root=new Node(3);
        root.left=new Node(5);
        root.right=new Node(2);
        int lca=LCA(root,root.left,root.right);
        Node temp_ans=ans;
        ans=null;
        System.out.println(temp_ans.data);
    }
    static int LCA(Node root,Node p1, Node p2){
        if(root==null)
            return 0;
        int LS=LCA(root.left,p1,p2);
        int RS=LCA(root.right,p1,p2);
        int tempVal=LS+RS+((root.data==p1.data)?1:0)+((root.data==p2.data)?1:0);
        if(ans==null && tempVal==2)
            ans=root;
        return tempVal;
    }
}

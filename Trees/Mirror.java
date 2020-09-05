package Questions.Trees_11;

public class Mirror {
    public static void main(String[] args) {
        Node root=new Node(3);
        root.left=new Node(2);
        root.right=new Node(2);
        root=mirror(root);//inverted tree
    }
    static Node mirror(Node root){
        if(root==null)
            return null;
        Node left=mirror(root.left);
        Node right=mirror(root.left);
        root.left=right;
        root.right=left;
        return root;
    }
}

package Questions.Trees_11;

public class RootToLeafPathSum {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(6);
        root.right = new Node(15);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.right.left = new Node(13);
        root.right.right = new Node(17);
        int K=23;
        System.out.println(isPathPossible(root,K));
    }
    static boolean isPathPossible(Node root,int sum){
        if(root==null)
            return false;
        if(isLeaf(root))
            return root.data==sum;
        return isPathPossible(root.left,sum- root.data) || isPathPossible(root.right,sum- root.data);
    }
    static boolean isLeaf(Node root){
        return (root.left==null && root.right==null);
    }

}

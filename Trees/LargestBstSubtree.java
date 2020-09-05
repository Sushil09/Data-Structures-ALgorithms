package Questions.Trees_11;


public class LargestBstSubtree {
    static int Nodes=0;
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(8);
        root.right.right = new Node(7);
        CustomBST customBST=findMaxSizeBST(root);
        int temps=Nodes;
        Nodes=0;
        System.out.println(temps);
    }
    static CustomBST findMaxSizeBST(Node root){
        if(root==null)
            return new CustomBST();
        if(isLeaf(root))
            return new CustomBST(1,true,root.data);
        CustomBST leftSide=findMaxSizeBST(root.left);
        CustomBST rightSide=findMaxSizeBST(root.right);
        if(leftSide.isBst && rightSide.isBst && root.data< rightSide.val && root.data> leftSide.val)
            Nodes=Math.max(Nodes,leftSide.countNodes+rightSide.countNodes+1);
        return new CustomBST(leftSide.countNodes+rightSide.countNodes+1, leftSide.isBst && rightSide.isBst,root.data);
    }
    static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }
}
class CustomBST{
    int countNodes;
    boolean isBst;
    int val;
    public CustomBST(){}
    public CustomBST(int countNodes, boolean isBst, int val) {
        this.countNodes = countNodes;
        this.isBst = isBst;
        this.val = val;
    }
}

package Questions.Trees_11;

public class SumBinaryTRee {
    static boolean flag=true;
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(6);
        root.right = new Node(15);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.right.left = new Node(13);
        root.right.right = new Node(17);
        boolean ans=true;
        int temp=isSumNode(root);
        if(root==null)
            ans=false;
        else
            ans=flag;
        flag=true;
        System.out.println(ans);
    }
    static int isSumNode(Node root){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return root.data;
        int leftSide=isSumNode(root.left);
        int rightSide=isSumNode(root.right);
        if(leftSide+rightSide!=root.data && flag)
            flag=false;
        return leftSide+rightSide+root.data;
    }
}

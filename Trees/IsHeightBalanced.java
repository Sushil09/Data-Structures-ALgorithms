package Questions.Trees_11;

public class IsHeightBalanced {
    public static void main(String[] args) {
        Node root=new  Node(1);
        root.right=new  Node(3);
        root.left=new  Node(2);
        root.left.right=new  Node(5);
        root.left.right.right=new  Node(6);
        root.left.right.right.right=new  Node(7);
        root.left.left=new  Node(4);
        root.left.left.left=new  Node(8);
        root.left.left.left.left=new  Node(9);
        System.out.println(isBalanced(root));
    }
    static boolean flag=true;
    static boolean isBalanced(Node  root) {
        boolean ans=true;
        int temp=checkBalanced(root);
        ans=flag;
        flag=true;
        return ans;
    }
    static int checkBalanced(Node  root){
        if(root==null)
            return -1;
        int leftSide=checkBalanced(root.left);
        int rightSide=checkBalanced(root.right);
        if(Math.abs(leftSide-rightSide)>1)
            flag=false;
        return 1+Math.max(leftSide,rightSide);
    }
}

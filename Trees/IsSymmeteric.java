package Questions.Trees_11;

public class IsSymmeteric {
    public static void main(String[] args) {
        Node root=new Node(3);
        root.left=new Node(2);
        root.right=new Node(2);
        System.out.println(isSym(root.left,root.left));
    }
    static boolean isSym(Node left,Node right){
        if(left==null && right==null)
            return true;
        if((left==null && right!=null)|| (left!=null && right==null))
            return false;
        return (left.data==right.data && isSym(left.left,right.right) && isSym(left.right,right.left));

    }
}

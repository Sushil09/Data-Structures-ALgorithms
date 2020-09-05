package Questions.Trees_11;

public class Height {
    static class Node{
        int data;
        Node left,right;
        Node(int x){
            this.data=x;
            this.left=null;
            this.right=null;
        }
    }
    public static void main(String[] args) {
        Node root=new Node(5);
//        root.left=new Node(2);
//        root.left.left=new Node(3);
        root.right=new Node(3);
        System.out.println(calcHeight(root));
    }
    static int calcHeight(Node root){
        if(root==null)
            return -1;
        int lh=calcHeight(root.left);
        int rh=calcHeight(root.right);
        return 1+Math.max(calcHeight(root.left),calcHeight(root.right));
    }
}

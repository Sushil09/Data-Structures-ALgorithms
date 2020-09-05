package Questions.Trees_11;

public class BSTRange {
    static int c=0;
    public static void main(String[] args) {
        Node root = new Node(17);
        root.left = new Node(32);
        root.right = new Node(25);
        root.left.left = new Node(46);
        root.left.right = new Node(17);
        root.right.left = new Node(27);
        root.right.right = new Node(40);
        root.left.left.left = new Node(9);
        count(root,11,26);
        System.out.println(c);
    }
    static void count(Node root, int B, int C){
        if(root==null || root.data<B || root.data>C)
            return ;
        if(root.data>=B && root.data<=C){
            c++;
            count(root.left,B,C);
            count(root.right,B,C);
        }
        else if(root.data>C){
            count(root.left,B,C);
        }
        else if(root.data<B)
            count(root.right,B,C);
    }
}


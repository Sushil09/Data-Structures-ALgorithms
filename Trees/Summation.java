package Questions.Trees_11;

import java.util.HashSet;

public class Summation {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(6);
        root.right = new Node(15);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.right.left = new Node(13);
        root.right.right = new Node(17);
        HashSet<Node> hs =new HashSet<>();
        populate(hs,root);
        for(Node x:hs)
            System.out.print (x.data+" ");

    }
    static void populate(HashSet<Node> hs, Node A){
        if(A==null)
            return;
       hs.add(A);
        populate(hs,A.left);
        populate(hs,A.right);
    }
}

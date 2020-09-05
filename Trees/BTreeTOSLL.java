package Questions.Trees_11;

class LL{
    Node head;
    Node tail;
    public LL(Node head,Node tail){
        this.head=head;
        this.tail=tail;
    }
}
public class BTreeTOSLL {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(6);
        root.right = new Node(15);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.right.left = new Node(13);
        root.right.right = new Node(17);
        contructSLL(root);
        printList(root);
    }
    static LL contructSLL(Node root){
        if(root==null)
            return new LL(null,null);
        LL ls=contructSLL(root.left);
        LL rs=contructSLL(root.right);
        if(root.left==null && root.right==null)
            rs.tail=root;
        if(rs.tail==null)
            rs.tail=ls.tail;
        root.left=null;
        if(ls.head==null){
            root.right=rs.head;
        }
        else{
            root.right=ls.head;
            if(ls.tail!=null)
            ls.tail.right=rs.head;
        }
        return new LL(root,rs.tail);
    }
    static void printList (Node head){
        Node trav=head;
        while(trav!=null) {
            System.out.print(trav.data + " ");
            trav=trav.right;
        }
    }
}

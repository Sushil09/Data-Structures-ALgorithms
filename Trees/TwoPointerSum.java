package Questions.Trees_11;

import java.util.Stack;

public class TwoPointerSum {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new  Node(6);
        root.right = new  Node(15);
        root.left.left = new  Node(4);
        root.left.right = new Node(7);
        root.right.left=new Node(13);
        root.right.right=new Node(17);
        Inorder i=new Inorder(root);
        ReversInorder rI=new ReversInorder(root);
        int K=16;
        Node p1=i.getNext();
        Node p2=rI.getNext();
        while(i.hasNext() && rI.hasNext()){
            if(p1.data+p2.data>K)
                p2=rI.getNext();
            else if(p1.data+p2.data<K)
                p1=i.getNext();
            else{
                System.out.println("The two nodes are "+p1.data+" and "+ p2.data);
                break;
            }
        }

    }
}
class Inorder{
    Stack<Node> st=new Stack<>();
    public Inorder(Node x){
        Node p=x;
        while(p!=null){
            st.push(p);
            p=p.left;
        }
    }
    public boolean hasNext(){
        return !st.isEmpty();
    }
    public Node getNext(){
            Node t=st.pop();
            Node x=t.right;
            while(x!=null){
                st.push(x);
                x=x.left;
            }
            return t;
    }
}
class ReversInorder{
    Stack<Node> st=new Stack<>();
    public ReversInorder(Node x){
        Node p=x;
        while(p!=null){
            st.push(p);
            p=p.right;
        }
    }
    public boolean hasNext(){
        return !st.isEmpty();
    }
    public Node getNext(){
        Node t=st.pop();
        Node x=t.left;
        while(x!=null){
            st.push(x);
            x=x.right;
        }
        return t;
    }
}

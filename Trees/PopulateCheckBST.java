package Questions.Trees_11;

class LargestBST{

   public int largestSize(Node root){
       CustomNode m=calcLarge(root);
       return m.size;
   }
   public CustomNode calcLarge(Node root){
       if(root==null)
           return new CustomNode();
       CustomNode lS=calcLarge(root.left);
       CustomNode rS=calcLarge(root.right);
       CustomNode m=new CustomNode();
       if(lS.checkBst==false || rS.checkBst==false || lS.max>root.data || rS.min<=root.data){
           m.checkBst=false;
           m.size=Math.max(lS.size, rS.size);
           return m;
       }
       m.checkBst=true;
       m.size= lS.size+ rS.size+1;
       m.min=root.left!=null? lS.min:root.data;
       m.max=root.right!=null? rS.max:root.data;
       return m;
   }
}
public class PopulateCheckBST {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(6);
        root.right = new Node(15);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.right.left = new Node(13);
        root.right.right = new Node(17);
        LargestBST c = new LargestBST();
        System.out.println(c.largestSize(root));
    }
}
class CustomNode {
    int size;
    boolean checkBst;
    int min, max;
    public CustomNode() {
        size = 0;
        checkBst = true;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }
}


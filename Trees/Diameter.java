package Questions.Trees_11;

public class Diameter {
    static class Node{
        int data;
        Height.Node left,right;
        Node(int x){
            this.data=x;
            this.left=null;
            this.right=null;
        }
    }
    static int ans=0;
    public static void main(String[] args) {
        Height.Node root = new Height.Node(17);
        root.left = new Height.Node(24);
        root.right = new Height.Node(10);
        root.left.left = new Height.Node(15);
        root.left.right = new Height.Node(28);
        root.left.left.left = new Height.Node(4);
        root.left.left.right = new Height.Node(4);
        root.right.right = new Height.Node(29);
        System.out.println(calcHeight(root));
    }
    static int calcHeight(Height.Node root){
        if(root==null)
            return -1;
        int lh=calcHeight(root.left);
        int rh=calcHeight(root.right);
        ans=Math.max(ans,lh+rh+2);
        return Math.max(lh,rh)+1;
    }
}

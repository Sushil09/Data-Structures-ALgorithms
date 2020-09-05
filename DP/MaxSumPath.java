package Questions.DP_15;

public class MaxSumPath {
    static int ans=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Node root=new Node(20);
//        root.left=new Node(-10);
//        root.right=new Node(20);
//        root.right.right=new Node(-50);
//        root.right.left=new Node(-10);
        System.out.println(maxSum(root));
    }
    static int maxSum(Node root){
        if(root==null)
            return 0;
        int left=maxSum(root.left);
        int right=maxSum(root.right);
        ans=Math.max(ans,Math.max(left,0)+Math.max(right,0)+root.x);
        return Math.max(0,root.x+Math.max(left,right));
    }
    static class Node{
        int x;
        Node left,right;
        Node(int x){
            this.x=x;
            this.left=this.right=null;
        }
    }
}

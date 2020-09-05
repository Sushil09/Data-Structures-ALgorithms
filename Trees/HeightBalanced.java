package Questions.Trees_11;

import Questions.Trees_11.Pair;

public class HeightBalanced {
    static class TreeNode{
        int data;
        TreeNode left,right;
        TreeNode(int x){
            this.data=x;
            this.left=null;
            this.right=null;
        }
    }
    public static void main(String[] args) {
        TreeNode x=new TreeNode(1);
        x.right=new TreeNode(3);
        x.left=new TreeNode(2);
        x.left.right=new TreeNode(5);
        x.left.right.right=new TreeNode(6);
        x.left.right.right.right=new TreeNode(7);
        x.left.left=new TreeNode(4);
        x.left.left.left=new TreeNode(8);
        x.left.left.left.left=new TreeNode(9);
        System.out.println(heightDiameter(x).first +" " +heightDiameter(x).second);

    }
    static Pair<Integer,Integer> heightDiameter(TreeNode root){
        if(root==null){
            Pair p=new Pair();
            p.first=-1;
            p.second=0;
            return p;
        }
        Pair<Integer,Integer> pl=heightDiameter(root.left);
        Pair<Integer,Integer> pr=heightDiameter(root.right);
        int height=1+Math.max(pl.first,pr.first);
        int op1=pl.first+pr.first+1;
        int ld=pl.second;
        int rd=pr.second;
        int dia=Math.max(op1,Math.max(ld,rd));
        Pair<Integer,Integer> x=new Pair<>();
        x.first=height;
        x.second=dia;
        return x;

    }

}

package Questions.Trees_11;

import java.util.LinkedList;
import java.util.Queue;

public class OddEvenSumDifference {
    public static void main(String[] args) {
        Node root=new  Node(1);
        root.right=new  Node(3);
        root.left=new  Node(2);
        root.left.right=new  Node(5);
        root.left.right.right=new  Node(6);
        root.left.right.right.right=new  Node(7);
        root.left.left=new  Node(4);
        root.left.left.left=new  Node(8);
        root.left.left.left.left=new  Node(9);
        System.out.println(solve(root));
    }
    static int solve(Node A) {
        if(A==null)
            return 0;
        long s1=0,s2=0;
        Queue<Node> q=new LinkedList<>();
        q.add(A);
        int level=1;
        while(!q.isEmpty()){
            int x=q.size();
            if(level%2!=0){
                for(int i=0;i<x;i++){
                    Node p=q.poll();
                    s1+=(long)p.data;
                    if(p.left!=null)
                        q.add(p.left);
                    if(p.right!=null)
                        q.add(p.right);
                }

                level++;
            }
            else{
                for(int i=0;i<x;i++){
                    Node p=q.poll();
                    s2+=(long)p.data;
                    if(p.left!=null)
                        q.add(p.left);
                    if(p.right!=null)
                        q.add(p.right);
                }
                level++;
            }
        }
        return (int)(s1-s2);
    }
}

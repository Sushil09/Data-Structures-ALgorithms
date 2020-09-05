package Questions.Trees_11;

import java.security.spec.RSAOtherPrimeInfo;

public class EqualTreePartition {
    static int flag=0;
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(6);
        root.right = new Node(15);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.right.left = new Node(13);
        root.right.right = new Node(17);
//        System.out.println(popSum(root));
        System.out.println(recurTree(root,36));
        System.out.println(flag);
    }
    static long recurTree(Node A,long sum) {
        if(A==null)
            return 0;
        long ls=recurTree(A.left,sum);
        long rs=recurTree(A.right,sum);
        long cs=ls+rs+(long)A.data;
        if(cs==sum)
            flag=1;
        return cs;
    }
    static long popSum(Node root){
        if(root==null)
            return 0;
        long ls=popSum(root.left);
        long rs=popSum(root.right);
        long cs=ls+rs+(long)root.data;
        return cs;
    }
}

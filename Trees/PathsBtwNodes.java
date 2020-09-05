package Questions.Trees_11;

public class PathsBtwNodes {
    static Node ancestor=null;
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(6);
        root.right = new Node(15);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.right.left = new Node(13);
        root.right.right = new Node(17);
        int x=findAncestor(root,4,17);
        int d1=findDis(ancestor,4,0);
        int d2=findDis(ancestor,17,0);
        System.out.println(d1+d2);
    }

    private static int findDis(Node root, int target, int level) {
        if(root==null)
            return -1;
        if(root.data==target)
            return level;
        int lsubTreeLevel=findDis(root.left,target,level+1);
        if(lsubTreeLevel==-1)
        return findDis(root.right,target,level+1);
        return lsubTreeLevel;
    }

    private static int findAncestor(Node root,int A,int B){
        if(root==null)
            return 0;
        int lsubTree=findAncestor(root.left,A,B);
        int rsubTree=findAncestor(root.right,A,B);
        int cs=lsubTree+rsubTree+(root.data==A?1:0)+(root.data==B?1:0);
        if(cs==2 && ancestor==null)
            ancestor=root;
        return cs;

    }
}

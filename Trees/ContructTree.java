package Questions.Trees_11;

public class ContructTree {
    static int i;
    public static void main(String[] args) {
        int[]inOrder={9,3,15,20,7};
        int[]postOrder={9,15,7,20,3};
        i= inOrder.length-1;
        Node root=constructUtil(inOrder,postOrder,0,inOrder.length-1);
    }
    static Node constructUtil(int[]inOrder,int[]postOrder,int l,int h){
        if(l>h)
            return null;
        int idx=finIdx(inOrder,postOrder[i],l,h);
        Node root=new Node(postOrder[i]);
        i--;
        if(l==h)
            return root;
        root.left=constructUtil(inOrder,postOrder,l,idx-1);
        root.right=constructUtil(inOrder,postOrder,idx+1,h);
        return root;
    }
    static int finIdx(int[]inOrder,int x,int l,int h){
        for(int j=l;j<=h;j++)
            if(x==inOrder[j])
                return j;
            return -1;
    }
}

package Questions.Tries_12;

class XorTree{
    XorTree left,right;
    int index;
}
public class Max_Xor {
    public static void main(String[] args) {
    int[]a={2, 6, 10, 2, 9, 9, 6, 10, 6, 8, 6, 4, 4};
        XorTree root=new XorTree();
        int b=(int)(Math.log10(maxDig(a))/Math.log10(2))  ;
        insert(root,a,b);
        System.out.println(findMaxXor(root,a,b));
    }
    static void insert(XorTree root, int[]a,int b){
        for(int i=0;i<a.length;i++){
            XorTree temp=root;
            for(int j=b;j>=0;j--){
                if(checkBit(a[i],j)){
                    if(temp.right==null)
                    temp.right=new XorTree();
                    temp=temp.right;
                }
                else{
                    if(temp.left==null)
                    temp.left=new XorTree();
                    temp=temp.left;
                }
            }
        }
    }
    static int findMaxXor(XorTree root,int []a,int b){
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            XorTree temp=root;
            int currMax=0;
            for(int j=b;j>=0;j--){
                if(checkBit(a[i],j)){
                    if(temp.left!=null){
                        currMax+=Math.pow(2,j);
                        temp=temp.left;
                    }
                    else
                        temp=temp.right;
                }
                else{
                    if(temp.right!=null){
                        currMax+=Math.pow(2,j);
                        temp=temp.right;
                    }
                    else
                        temp=temp.left;
                }

            }
            ans=Math.max(ans,currMax);
        }
        return ans;
    }
    static int maxDig(int []a){
        int max=a[0];
        for(int x:a)
            max=Math.max(x,max);
        return max;
    }
    static boolean checkBit(int x,int i){
        x=x>>i;
        if((x&1)==1)
            return true;
        return false;
    }

}

package Questions.Tries_12;

import java.util.ArrayList;

public class Max_Xor_SubArray {
    public static void main(String[] args) {
        int[]a={1,4,3};
        int []preFixArray=findPrefix(a);
        XorTree root=new XorTree();
        int b=(int)(Math.log10(maxDig(preFixArray))/Math.log10(2))  ;
        insert(root,preFixArray,b);
        int[]x=findMaxXor(root,preFixArray,b);
        int[]ans=new int[2];
        for(int i=0;i<preFixArray.length;i++)
            if((preFixArray[x[0]]^preFixArray[i])==x[1])
                ans[0]=i;
          ans[1]=x[0];
          if(ans[0]==0)
              ans[0]++;
          else
              ans[0]+=2;
        System.out.println(ans[0]);
          System.out.println(x[0]+1);

        System.out.println(x[1]);
//          for(int u:ans)
//              System.out.println(u+1);
    }
    private static int[] findPrefix(int[] a) {
        int[]x=new int[a.length];
        int xor=0;
        for(int i=0;i<a.length;i++){
            xor^=a[i];
            x[i]=xor;
        }
        return x;
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
            temp.index=i;
        }
    }
    static int[] findMaxXor(XorTree root,int []a,int b){
        int []ansarray=new int[2];
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
            if(ans<currMax){
                ans=Math.max(ans,currMax);
                ansarray[0]=temp.index;
                ansarray[1]=ans;

            }
        }
        return ansarray;
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

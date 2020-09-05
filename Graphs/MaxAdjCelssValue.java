package Questions.Graphs_16;

import java.util.Arrays;

public class MaxAdjCelssValue {
    public static void main(String[] args) {
        int A=3,B=3;
        int[][]C={{1,5,6},
                  {10,7,2},
                  {3,6,9}};
        int[][]ans=new int[A][B];
        for(int i=0;i<A;i++)
            Arrays.fill(ans[i],Integer.MAX_VALUE);
        int []XX={-1,1,0,0};
        int []YY={0,0,-1,1};
        for(int i=0;i<A;i++){
            for(int j=0;j<B;j++){
                for(int k=0;k<4;k++){
                    int xx=i+XX[k];
                    int yy=j+YY[k];
                    if(isValid(A,B,xx,yy))
                        ans[i][j]=Math.min(ans[i][j],Math.abs(C[i][j]-C[xx][yy]));
                }
            }
        }
        int max=0;
        for(int[]a:ans){
            for(int r:a){
                System.out.print(r+" ");
                max=Math.max(r,max);
            }
            System.out.println();

        }
        System.out.println(max);
    }
    static boolean isValid(int A,int B,int i,int j){
        return i>=0 && j>=0 && i<A && j<B;
    }
}

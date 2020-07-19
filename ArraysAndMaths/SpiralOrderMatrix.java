package Questions.Maths_And_Arrays_1;

public class SpiralOrderMatrix {
    public static void main(String[] args) {
        int a=4;
        printSpiral(a);
    }
    static void printSpiral(int a){
        int[][]matrix=new int[a][a];
        int x=1;
        int rInc=0,rDec=a-1,cInc=0,cDec=a-1;
        while(x<=a*a){
            for(int c=cInc;c<=cDec;c++){
                matrix[rInc][c]=x;
                x++;
            }
            rInc++;
            for(int c=rInc;c<=rDec;c++){
                matrix[c][cDec]=x;
                x++;
            }
            cDec--;
            for(int c=cDec;c>=cInc;c--){
                matrix[rDec][c]=x;
                x++;
            }
            rDec--;
            for(int c=rDec;c>=rInc;c--){
                matrix[c][cInc]=x;
                x++;
            }
            cInc++;
        }
        for(int[]ans:matrix) {
            for (int y : ans)
                System.out.print(y+" ");
            System.out.println();
        }
    }
}

package Questions.Graphs_16;

public class Flyod_Warshall {
    public static void main(String[] args) {
        //-1  represent no directly connected
        int[][]A={{0,50,39},
                  {-1,0,1},
                  {-1,10,0}};
        Floyd f=new Floyd();
        f.calcAllPair(A);
        for(int[]x:A){
            for(int y:x)
                System.out.print(y+ " ");
            System.out.println();
        }
    }
}
class Floyd{
    void calcAllPair(int[][]graph){
        int N=graph.length,M=graph[0].length;
        //filling with Infinity for all dis-connected edges
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++)
                if(graph[i][j]==-1)
                    graph[i][j]=Integer.MAX_VALUE/2;
        }
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(graph[i][j]>graph[i][k]+graph[k][j])
                        graph[i][j]=graph[i][k]+graph[k][j];
                }
            }
        }
    }
}
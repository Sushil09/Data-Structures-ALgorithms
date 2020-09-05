package Questions.Graphs_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {
    static int V;
    public static void main(String[] args) {
        V=6;
        int[][]a={{0, 4, 9},
                    {3, 4, 6},
                    {1, 2, 1},
                    {2, 5, 1},
                    {2, 4, 5},
                    {0, 3, 7},
                    {0, 1, 1},
                    {4, 5, 7},
                    {0, 5, 1}};
        int S=4,D=2;
        ArrayList<ArrayList<EdgeNode>> G=createGraph(a,V);
        System.out.println(shortestDistance(G,S,D));
    }
    static int shortestDistance(ArrayList<ArrayList<EdgeNode>> G,int S,int D){
        int []dis=new int[G.size()-1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[S]=0;
        PriorityQueue<EdgeNode> pq=new PriorityQueue<>(G.size(),new EdgeNode());
        pq.add(new EdgeNode(S,0));
        while(pq.size()>0) {
            EdgeNode x = pq.poll();
            int d = x.distance;
            int u = x.node;
            for (EdgeNode neighbours : G.get(u)) {
                int tempNode = neighbours.node;
                int tempdis = neighbours.distance;
                if (dis[tempNode] > d + tempdis) {
                    dis[tempNode] = d + tempdis;
                    pq.add(new EdgeNode(tempNode, d + tempdis));
                }
            }
        }
        for(int x: dis)
            System.out.print(x+" ");
        System.out.println();
        return dis[D];
    }
    static ArrayList<ArrayList<EdgeNode>> createGraph(int[][]a,int V){
        ArrayList<ArrayList<EdgeNode>> G=new ArrayList<>();
        for(int i=0;i<=V;i++)
            G.add(new ArrayList<>());
        for(int i=0;i<a.length;i++){
            int u=a[i][0],v=a[i][1],w=a[i][2];
            G.get(u).add(new EdgeNode(v,w));
            G.get(v).add(new EdgeNode(u,w));
        }
        return G;
    }
}
class EdgeNode implements Comparator<EdgeNode> {
    int node,distance;
    //empty ctor
    public EdgeNode() {
    }
    //paramertized ctor
    public EdgeNode(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
    public int compare(EdgeNode e1,EdgeNode e2){
        return e1.distance-e2.distance;
    }
}

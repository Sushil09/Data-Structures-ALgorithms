package Questions.Graphs_16;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
   private Map<Integer,GraphNode> map=new HashMap<>();

    class GraphNode{
        int data;
        GraphNode parent;
        int rank;
    }
    public void makeEdge(int data){
        GraphNode n=new GraphNode();
        n.data=data;
        n.parent=n;
        n.rank=0;
        map.put(data,n);
    }
    public void union(int a,int b){
        GraphNode n1=map.get(a);
        GraphNode n2=map.get(b);

        GraphNode p1=findParent(n1);
        GraphNode p2=findParent(n2);

        if(p1==p2)
            return;
        if(p1.rank>=p2.rank){
            p1.rank=(p1.rank==p2.rank)?p1.rank+1:p1.rank;
            p2.parent=p1;
        }
        else{
            p1.parent=p2;
        }
    }
    private GraphNode findParent(GraphNode n){
        GraphNode parent=n.parent;
        if(parent==n)
            return n;
        n.parent=findParent(n.parent);
        return n.parent;
    }
    public int findSet(int data) {
        return findParent(map.get(data)).data;
    }
    public static void main(String[] args) {
        DisjointSet ds=new DisjointSet();
        ds.makeEdge(1);
        ds.makeEdge(2);
        ds.makeEdge(3);
        ds.makeEdge(4);
        ds.makeEdge(5);
        ds.makeEdge(6);
        ds.makeEdge(7);

        ds.union(1,2);
        ds.union(2,3);
        ds.union(4,5);
        ds.union(6,7);
        ds.union(5,6);
        ds.union(3,7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));
    }
}

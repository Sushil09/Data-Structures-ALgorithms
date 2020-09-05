package Questions.Graphs_16;

import java.util.*;

public class CloneUDGraph {
    public static void main(String[] args) {
        Graph g=new Graph();
        UndirectedGraphNode src=g.buildGrapgh();
        g.cloneGraph(src);
    }
}

//Sample Graph
/*1--2
  |  |
  4--3*/
class Graph {
    public UndirectedGraphNode buildGrapgh() {
        UndirectedGraphNode n1 = new UndirectedGraphNode(1);
        UndirectedGraphNode n2 = new UndirectedGraphNode(2);
        UndirectedGraphNode n3 = new UndirectedGraphNode(3);
        UndirectedGraphNode n4 = new UndirectedGraphNode(4);
        List<UndirectedGraphNode> l = new ArrayList<>();
        l.add(n2);
        l.add(n4);
        n1.neighbors = l;
        l = new ArrayList<>();
        l.add(n1);
        l.add(n3);
        n2.neighbors = l;
        l = new ArrayList<>();
        l.add(n2);
        l.add(n4);
        n3.neighbors = l;
        l = new ArrayList<>();
        l.add(n3);
        l.add(n1);
        n4.neighbors = l;
        return n1;
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode source) {
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(source);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<>();
        hm.put(source, new UndirectedGraphNode(source.label));
        while (!q.isEmpty()) {
            UndirectedGraphNode u = q.poll();
            UndirectedGraphNode cloned = hm.get(u);
            if (u.neighbors != null) {
//                List<UndirectedGraphNode> l=u.neighbors;
                for (UndirectedGraphNode x : u.neighbors) {
                    UndirectedGraphNode clonedNodeG = hm.get(x);
                    if (clonedNodeG == null) {
                        q.add(x);
                        clonedNodeG = new UndirectedGraphNode(x.label);
                        hm.put(x, clonedNodeG);
                    }
                    cloned.neighbors.add(clonedNodeG);
                }
            }
        }
        return hm.get(source);
    }
}
class UndirectedGraphNode {
     int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  }
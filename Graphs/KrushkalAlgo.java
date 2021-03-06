package Questions.Graphs_16;

import java.util.*;

public class KrushkalAlgo {
    Map<Integer,Integer> parent=new HashMap<>();
    public void makeSet(int N){
        for(int i=1;i<=N;i++){
            parent.put(i,i);
        }
    }
    int Find(int k){
        if(parent.get(k)==k)
            return k;
        return Find(parent.get(k));
    }
    void Union(int x,int y){
        int first=Find(x);
        int second=Find(y);
        if(first==second)
            return;
        parent.put(first,second);
    }
    static ArrayList<Integer> makeMst(int[][]a,int V){
        ArrayList<Integer> ans=new ArrayList<>();
         KrushkalAlgo al=new KrushkalAlgo();
         al.makeSet(V);
//        for (int i=0;i<V;i++)
//            ans.add(new ArrayList<>());
        int i=0;
        while (ans.size()!=V-1 && i<a.length){
            int u=a[i][0],v=a[i][1],w=a[i][2];
            int p1=al.Find(u);
            int p2=al.Find(v);
            if(p1!=p2){
                ans.add(w);
                al.Union(p1,p2);
            }
            i++;
        }
       for(Map.Entry<Integer,Integer> m:al.parent.entrySet()){
           System.out.print(m.getKey()+" "+ m.getValue());
           System.out.println();
       }

        return ans;
    }

    public static void main(String[] args) {
        int V=4;
        int[][]a={{1,2,1},
                  {2,3,4},
                  {1,4,3},
                  {4,3,2},
                  {1,3,10}};
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
//        KrushkalAlgo al=new KrushkalAlgo();
        ArrayList<Integer> ans=makeMst(a,V);
            for (int c : ans)
                System.out.print(c + " ");


    }
}

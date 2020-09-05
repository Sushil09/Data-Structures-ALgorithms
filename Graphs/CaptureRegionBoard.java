package Questions.Graphs_16;

import Questions.Pair_;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CaptureRegionBoard {
    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> c=new ArrayList<>();
        for(int i=0;i<4;i++)
            c.add(new ArrayList<Character>());
        //filling the list
        c.get(0).add('X');c.get(0).add('X');c.get(0).add('X');c.get(0).add('X');
        c.get(1).add('X');c.get(1).add('O');c.get(1).add('O');c.get(1).add('X');
        c.get(2).add('X');c.get(2).add('X');c.get(2).add('O');c.get(2).add('X');
        c.get(3).add('X');c.get(3).add('O');c.get(3).add('X');c.get(3).add('X');
        int N=c.size(),M=c.get(0).size();
        List<Pair_> inc=new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(c.get(i).get(j)=='O' && (i==0 || j==0 || i==N-1 || j==M-1))
                    inc.add(new Pair_(i,j));
            }
        }
        for(int i=0;i<inc.size();i++){
            Pair_ temp=inc.get(i);
            int x=(Integer) temp.first;int y=(Integer)temp.second;
            if(c.get(x).get(y)=='O')
                bfs(c,temp,N,M);
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(c.get(i).get(j)=='O')
                    c.get(i).set(j,'X');
                if(c.get(i).get(j)=='-')
                    c.get(i).set(j,'O');
            }
        }
        for(List<Character> t:c){
            for(char f:t)
                System.out.print(f+" ");
            System.out.println();
        }
    }
    static void bfs(ArrayList<ArrayList<Character>> c,Pair_ src,int N,int M){
        Queue<Pair_> q=new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()){
            Pair_ temp=q.poll();
            int x=(Integer) temp.first;
            int y=(Integer) temp.second;
            c.get(x).set(y, '-');
            //up
            if(isValid(c,x-1,y,N,M)) {
                if (c.get(x - 1).get(y) == 'O') {
                    q.add(new Pair_(x-1,y));
                }
            }
            //down
            if(isValid(c,x+1,y,N,M)) {
                if (c.get(x + 1).get(y) == 'O') {
                    q.add(new Pair_(x+1,y));
                }
            }
            //left
            if(isValid(c,x,y-1,N,M)) {
                if (c.get(x).get(y-1) == 'O') {
                    q.add(new Pair_(x,y-1));
                }
            }
            //right
            if(isValid(c,x,y+1,N,M)) {
                if (c.get(x).get(y+1) == 'O') {
                    q.add(new Pair_(x,y+1));
                }
            }
        }
    }
    static boolean isValid(ArrayList<ArrayList<Character>> c,int i,int j,int N,int M){
        return i>=0 && j>=0 && i<N && j<M;
    }
}

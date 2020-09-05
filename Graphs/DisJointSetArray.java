package Questions.Graphs_16;

import java.util.*;

// class to represent a disjoint set
public class DisJointSetArray
{
    private Map<Integer, Integer> parent = new HashMap();

    // stores the depth of trees
    private Map<Integer, Integer> rank = new HashMap();

    // perform MakeSet operation
     void makeSet(int[] universe)
    {
        // create n disjoint sets (one for each item)
        for (int i : universe)
        {
            parent.put(i, i);
            rank.put(i, 0);
        }
    }

    // Find the root of the set in which element k belongs
     int Find(int k)
    {
        // if k is not root
        if (parent.get(k) != k)
            // path compression
            parent.put(k, Find(parent.get(k)));

        return parent.get(k);
    }

    // Perform Union of two subsets
     void Union(int a, int b)
    {
        // find root of the sets in which elements
        // x and y belongs
        int x = Find(a);
        int y = Find(b);

        // if x and y are present in same set
        if (x == y)
            return;

        // Always attach smaller depth tree under the
        // root of the deeper tree.
        if (rank.get(x) > rank.get(y))
            parent.put(y, x);
        else if (rank.get(x) < rank.get(y))
            parent.put(x, y);
        else
        {
            parent.put(x, y);
            rank.put(y, rank.get(y) + 1);
        }
    }

    public static void printSets(int[] universe, DisJointSetArray ds)
    {
        int N=universe.length;
//        for (int i : universe)
//            System.out.print(ds.Find(i) + " ");
        for(int i=0;i<N;i++)
            universe[i]=ds.Find(universe[i]);
    }

    public static void main(String[] args)
    {
        // universe of items
        int[] universe = { 1, 2, 3, 4, 5 };
        // initialize DisJointSetArray class
        DisJointSetArray ds = new DisJointSetArray();

        // create singleton set for each element of universe
        ds.makeSet(universe);
        printSets(universe, ds);

        ds.Union(4, 3); // 4 and 3 are in same set
        printSets(universe, ds);

        ds.Union(2, 1); // 1 and 2 are in same set
        printSets(universe, ds);

        ds.Union(1, 3); // 1, 2, 3, 4 are in same set
        printSets(universe, ds);
    }
}
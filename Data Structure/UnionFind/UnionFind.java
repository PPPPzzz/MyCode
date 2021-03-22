import java.util.ArrayList;
import java.lang.IllegalAccessException;

public class UnionFind {
    int[] parent;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        parent = new int[n];
        // set all the parents to be -1 to symbolize that they are disjoint
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
    }

    /* Throws an exception if v1 is not a valid vertex. */
    private void validate(int v1) throws IllegalAccessException{
        // TODO
        if(v1 >= parent.length)
            throw new IllegalAccessException("error");
        if(v1 < 0)
            throw new IllegalAccessException("error");
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        try{
            validate(v1);
        }
        catch(IllegalAccessException e) {
            System.out.println("Caught " + e);
        }
        int root = find(v1);
        return -1 * parent[root];
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        return parent[v1];
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean isConnected(int v1, int v2) {
        // TODO
        try{
            validate(v1);
            validate(v2);
        }
        catch(IllegalAccessException e) {
            System.out.println("Caught " + e);
        }
        if(find(v1) == find(v2))
            return true;
        else
            return false;
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Connecting a
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void connect(int v1, int v2) {
        // TODO
        try{
            validate(v1);
            validate(v2);
        }
        catch(IllegalAccessException e){
            System.out.println("Caught " + e);
        }
        if(isConnected(v1, v2))
        {
            System.out.println(v1 + " " + v2 +" are already connected.");
            return;
        }
        if(parent(v1) < 0 && parent(v2) < 0) //both roots
            if(parent[v1] < parent[v2]) //v1's set is bigger than v2's set
                arrayconnect(v2, v1);
            else //v1's set is smaller than / equals to v2's set
                arrayconnect(v1, v2);
        else
            if(find(v1) != v1 && find(v2) != v2) //both nodes
                if(parent[find(v1)] < parent[find(v2)]) //v1's set is smaller than v2's set
                    arrayconnect(find(v2), find(v1));
                else //v1's set is smaller than / euqals to v2's set
                    arrayconnect(find(v1), find(v2));
            else //one is root and the other is node
                if(find(v1) == v1) //v1 is root
                    if(parent[v1] < parent[find(v2)]) //v1's set is bigger than v2's set
                        arrayconnect(find(v2), v1);
                    else //v1's set is smaller than / equals to v2's set
                        arrayconnect(v1, find(v2));
                else //v2 is root
                    if(parent[find(v1)] < parent[v2]) //v1's set is bigger than v2's set
                        arrayconnect(v2, find(v1));
                    else //v1's set is smaller than / euqals to v2's set
                        arrayconnect(find(v1), v2);
    }

    /* Returns the root of the set v1 belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int v1) {
        // TODO
        try{
            validate(v1);
        }
        catch(IllegalAccessException e) {
            System.out.println("Caught " + e);
        }
        if(parent[v1] < 0)
            return v1;
        parent[v1] = find(parent[v1]);
        return parent[v1];
    }

    private void arrayconnect(int a, int b)
    {
        parent[b] += parent[a];
        parent[a] = b;
    }

    public static void main(String[] args) {
        UnionFind a = new UnionFind(20);
        a.printunion();
        a.connect(0, 1);
        a.printunion();
        a.connect(2, 3);
        a.printunion();
        a.connect(0, 2);
        a.printunion();
        a.connect(4, 5);
        a.connect(5, 6);
        a.printunion();
        a.connect(6, 1);
        a.printunion();
    }

    public void printunion()
    {
        for(int i = 0; i < 20; i++)
            System.out.print(String.format("%1$4s", i));
        System.out.println();
        for(int i: parent)
            System.out.print(String.format("%1$4s", i));
        System.out.println();
        System.out.println();
    }
}
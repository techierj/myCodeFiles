/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank.GraphTheory;

import com.sun.org.apache.bcel.internal.generic.Instruction;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author jaimin
 */
public class KruskalMST_ReallySpecialSubtree {

    static PrintWriter out;

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        out = new PrintWriter(System.out);

        
        
        int v = in.readInt();
        int e = in.readInt();
        
        Graph g = new Graph(v,e);
        
        for(int i=0;i<e;i++){
            g.edge[i].src = in.readInt()-1;
            g.edge[i].dest = in.readInt()-1;
            g.edge[i].weight = in.readInt();
        }
        out.print(g.KruskalMST(in.readInt()-1));
        
        out.flush();

    }

    static final class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() throws IOException {
            if (curChar >= numChars) {
                curChar = 0;
                numChars = stream.read(buf);
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public final int readInt() {
            return (int) readLong();
        }

        public final long readLong() {
            int c = 0;
            try {
                c = read();
            } catch (IOException ex) {
            }
            while (isSpaceChar(c)) {
                try {
                    c = read();
                } catch (IOException ex) {
                }
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                try {
                    c = read();
                } catch (IOException ex) {
                }
            }
            long res = 0;
            do {
                if (c < '0' || c > '9');
                res *= 10;
                res += (c - '0');
                try {
                    c = read();
                } catch (IOException ex) {
                }
            } while (!isSpaceChar(c));
            return negative ? (-res) : (res);
        }

        public final String readString() {
            int c = 0;
            try {
                c = read();
            } catch (IOException ex) {
            }
            while (isSpaceChar(c)) {
                try {
                    c = read();
                } catch (IOException ex) {
                }
            }
            StringBuilder res = new StringBuilder();
            do {
                res.append((char) c);
                try {
                    c = read();
                } catch (IOException ex) {
                }
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}

class Graph
{
    // A class to represent a graph edge
    class Edge implements Comparable<Edge>
    {
        int src, dest, weight;
 
        // Comparator function used for sorting edges based on
        // their weight
        public int compareTo(Edge compareEdge)
        {
            if(this.weight!=compareEdge.weight)
                return this.weight-compareEdge.weight;
            else
                return (this.weight+this.src+this.dest)-(compareEdge.weight+compareEdge.src+compareEdge.dest);
        }
    };
 
    // A class to represent a subset for union-find
    class subset
    {
        int parent, rank;
    };
 
    int V, E;    // V-> no. of vertices & E->no.of edges
    Edge edge[]; // collection of all edges
 
    // Creates a graph with V vertices and E edges
    Graph(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }
 
    // A utility function to find set of an element i
    // (uses path compression technique)
    int find(subset subsets[], int i)
    {
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
 
        return subsets[i].parent;
    }
 
    // A function that does union of two sets of x and y
    // (uses union by rank)
    void Union(subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
 
        // Attach smaller rank tree under root of high rank tree
        // (Union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
 
        // If ranks are same, then make one as root and increment
        // its rank by one
        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
 
    // The main function to construct MST using Kruskal's algorithm
    int KruskalMST(int src)
    {
        int min = 0;
        int e = 0;  // An index variable, used for result[]
        int i = 0;  // An index variable, used for sorted edges
        
 
        // Step 1:  Sort all the edges in non-decreasing order of their
        // weight.  If we are not allowed to change the given graph, we
        // can create a copy of array of edges
        
        
        Arrays.sort(edge);
        
        // Allocate memory for creating V ssubsets
        subset subsets[] = new subset[V];
        for(i=0; i<V; ++i)
            subsets[i]=new subset();
 
        // Create V subsets with single elements
        for (int v = 0; v < V; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i=0;
        e=0;
        // Number of edges to be taken is equal to V-1
        while (e < V - 1)
        {
            // Step 2: Pick the smallest edge. And increment the index
            // for next iteration
            Edge next_edge = new Edge();
            next_edge = edge[i++];
 
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
 
            // If including this edge does't cause cycle, include it
            // in result and increment the index of result for next edge
            if (x != y)
            {
                ++e;
                min+=next_edge.weight;
                Union(subsets, x, y);
            }
            // Else discard the next_edge
        }
 
        return min;
    }
}
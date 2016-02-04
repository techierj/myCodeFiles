/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank.GraphTheory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author jaimin
 */
public class PrimsMSTSpecialSubtree {

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);

        int n = in.readInt();
        int m = in.readInt();
        
        Graph3 g = new Graph3(n);
        
        while (m-- > 0) {
            g.addNode(in.readInt()-1, in.readInt()-1,in.readInt());
        }
        System.out.println(g.prime(in.readInt()-1));

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

class Graph3 {

    boolean[] visited;
    List<Node>[] graph;
    Queue<Node> q;
    int N;
    Graph3(int n) {
        N = n;
        visited = new boolean[n];
        q = new PriorityQueue<Node>(n, new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });
        graph = (ArrayList<Node>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Node>();
        }
    }

    void addNode(int i, int j, int w) {
        Node temp = new Node(i, w);
        graph[j].add(temp);
        temp = new Node(j, w);
        graph[i].add(temp);
    }

    long prime(int source) {
        int count = 1;
        long min = 0;
        q.add(new Node(source, 0));
        visited[source]=true;
        while(!q.isEmpty()){
            Node u = q.poll();
            
            while(!graph[u.i].isEmpty()){
                Node v = graph[u.i].remove(0);
                if(!visited[v.i]){
                    q.add(v);
                }
            }
            if(!visited[u.i]){
                ++count;
                min+=u.weight;
                //System.out.println(u.i);
            }
            if(count==N){
                return min;
            }
            visited[u.i]=true;
        }
        return min;
    }

    class Node {

        int i;
        int weight;

        Node(int i, int w) {
            this.i = i;
            weight = w;
        }
    }
}

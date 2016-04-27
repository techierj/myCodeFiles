/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author jaimin
 */
public class JustShortestDistanceProblem {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int n = in.readInt();
        int m = in.readInt();
        Graph2 g = new Graph2(n, m);
        boolean prv = false;
        for (int i = 0; i < m; i++) {
            int type = in.readInt();
            int x = in.readInt() - 1;

            if (type == 1) {

                if (!prv) {
                    g.clear(n, m);
                }
                if (g.dis[x] == Integer.MAX_VALUE) {
                    out.println("-1");
                } else {
                    out.println(g.dis[x]);
                }
                prv = true;
            } else {
                int y = in.readInt() - 1;
                g.add(x, y, 1);
                prv = false;
            }
        }

        out.flush();
        out.close();
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

class Graph2 {

    List<Node>[] graph;
    boolean[] visited;
    int[] dis;
    Queue<Node> pq;
    int n;

    Graph2(int n, int v) {
        this.n = n;
        pq = new PriorityQueue<Node>(v, new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });
        graph = (ArrayList<Node>[]) new ArrayList[n];
        visited = new boolean[n];
        dis = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Node>();
            dis[i] = Integer.MAX_VALUE;
        }
    }

    void add(int x, int y, int weight) {
        Node temp = new Node(y, weight);
        graph[x].add(temp);
        temp = new Node(x, weight);
        graph[y].add(temp);

    }

    void dijkstra(int v) {
        
        while (!pq.isEmpty()) {
            Node temp2 = pq.poll();
            //System.out.print(temp2.x + "..\n");
            int i=0;
            while (i<graph[temp2.x].size()) {
                Node t = graph[temp2.x].get(i++);
                //  System.out.print(t.weight+" "+t.x+" : ");

                if (!visited[temp2.x] && dis[t.x] > dis[temp2.x] + t.weight) {
                    dis[t.x] = dis[temp2.x] + t.weight;
                    pq.add(new Node(t.x, dis[temp2.x] + t.weight));
                }
            }
            visited[temp2.x] = true;
        }
    }

    void clear(int n, int m) {
        visited = new boolean[n];
        dis = new int[n];
        for (int i = 0; i < n; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        pq = new PriorityQueue<Node>(m, new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });
        pq.add(new Node(0, 0));
        dis[0] = 0;
        dijkstra(m);
    }

    class Node {

        int x;
        int weight;

        Node(int v, int dis) {
            x = v;
            weight = dis;
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

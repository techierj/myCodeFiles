/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeMonk.GraphTheory.II;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author jaimin
 */
public class MittalWantsToGoToplay {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int t = in.readInt();
        while (t-- > 0) {
            int n = in.readInt();
            int m = in.readInt();

            //Queue<Integer> pq = new PriorityQueue<Integer>(m, Collections.reverseOrder());
            //pq.add(0);
            Graph2 g = new Graph2(n, m);
            for (int i = 0; i < m; i++) {
                g.add(in.readInt() - 1, in.readInt() - 1, in.readInt());
            }
            g.dijkstra(m);
            /*for (long i : g.dis) {
             out.print(i + " ");
             }*/

            int k = in.readInt();
            while (k-- > 0) {
                int home = in.readInt();

                long time = g.dis[home - 1] * 2;

                long givenTime = in.readLong();

                long timePlay = givenTime - time;
                if (timePlay < 0) {
                    out.println("0");
                } else {
                    out.println(timePlay);
                }

            }

        }

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

class Graph2 {

    List<Node>[] graph;
    boolean[] visited;
    int[] dis;
    Queue<Node> pq;

    Graph2(int n, int v) {
        pq = new PriorityQueue<Node>(v, new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });
        Node t = new Node(0, 0);
        pq.add(t);
        graph = (ArrayList<Node>[]) new ArrayList[n];
        visited = new boolean[n];
        dis = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Node>();
            dis[i] = Integer.MAX_VALUE;
        }
        dis[0] = 0;
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
            //System.out.print(temp2.weight + ",,");

            while (!graph[temp2.x].isEmpty()) {
                Node t = graph[temp2.x].remove(0);
                //System.out.print(t.weight+" ");

                if (!visited[temp2.x] && dis[t.x] > t.weight + dis[temp2.x]) {
                    dis[t.x] = t.weight + dis[temp2.x];
                    pq.add(new Node(t.x, t.weight + dis[temp2.x]));
                }

            }

            visited[temp2.x] = true;
        }

    }

    class Node {

        int x;
        int weight;

        Node(int v, int dis) {
            x = v;
            weight = dis;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author jaimin
 */
public class BreadthFirstSearch_ShortestReach {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);

        int t = in.readInt();
        while (t-- > 0) {
            int n = in.readInt();
            int m = in.readInt();
            Graph graph = new Graph(n);
            for (int i = 0; i < m; i++) {
                int x = in.readInt()-1;
                int y = in.readInt()-1;
                graph.add(x, y);
                graph.add(y, x);
            }
            int pos = in.readInt()-1;
            graph.bfs(pos);
            graph.printVal(n-1,pos);
        }

        System.out.print(sb);

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

class Graph {

    List<Integer>[] graph;
    boolean[] visited;
    int[] dis;

    Graph(int n) {
        graph = (ArrayList<Integer>[]) new ArrayList[n];
        visited = new boolean[n];
        dis = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            dis[i] = -1;
        }
    }

    void add(int x, int y) {
        graph[x].add(y);
        graph[y].add(x);
    }

    void bfs(int pos) {
        Queue<Integer> q = new LinkedList<Integer>();
        while (graph[pos].isEmpty()==false) {
            int val = graph[pos].remove(0);
            q.add(val);
            visited[val] = true;
            dis[val] = 6;
        }
        //while() To b continue....
        while (q.isEmpty()==false) {
            int i = q.poll();
            int temp = dis[i] + 6;
            while (graph[i].isEmpty()==false) {
                int j = graph[i].remove(0);
                if (!visited[j]) {
                    dis[j] = temp;
                    q.add(j);
                    visited[j]=true;
                }
            }
        }
        
    }
    
    void printVal(int n,int pos){
        for(int i=0;i<=n;i++){
            if(i==pos) continue;
            System.out.print(dis[i]+" ");
        }
        System.out.println();
    }
}

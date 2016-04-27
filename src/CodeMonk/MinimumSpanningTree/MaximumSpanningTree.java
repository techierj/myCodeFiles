/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeMonk.MinimumSpanningTree;

import java.io.IOException;
import java.io.InputStream;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author jaimin
 */
public class MaximumSpanningTree {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        int t = in.readInt();
        while (t-- > 0) {
            int n = in.readInt();
            int m = in.readInt();

            Queue<WeightedGraph> queue = new PriorityQueue<WeightedGraph>();
            while (m-- > 0) {
                WeightedGraph temp = new WeightedGraph(in.readInt() - 1, in.readInt() - 1, in.readInt());
                queue.add(temp);
            }

            DJUS dj = new DJUS(n);
            long max = 0;
            while (queue.size() > 0) {
                WeightedGraph temp = queue.poll();
                if (dj.root(temp.x) != dj.root(temp.y)) {
                    dj.union(temp.x, temp.y);
                    max += temp.weight;
                }
            }
            sb.append(max + "\n");
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

class WeightedGraph implements Comparable<WeightedGraph> {

    int x;
    int y;
    int weight;

    public WeightedGraph(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }

    int getWeight() {
        return this.weight;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    @Override
    public int compareTo(WeightedGraph o) {
        if (this.weight > o.weight) {
            return -1;
        } else if (this.weight < o.weight) {
            return 1;
        } else {
            return 0;
        }
    }

}

class DJUS {

    int[] arr, size;

    public DJUS(int n) {
        arr = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }

    int root(int p) {
        while (p != arr[p]) {
            arr[p] = arr[arr[p]];
            p = arr[p];
        }
        return p;
    }

    void union(int a, int b) {
        int i = root(a);
        int j = root(b);

        if (i == j) {
            return;
        }

        if (size[i] < size[j]) {
            arr[i] = j;
            size[j] += size[i];
        } else {
            arr[j] = i;
            size[i] += size[j];
        }
    }
}

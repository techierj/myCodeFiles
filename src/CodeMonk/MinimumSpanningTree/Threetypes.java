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
public class Threetypes {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);

        int n = in.readInt();
        int m = in.readInt();
        pair[] men = new pair[n];
        pair[] wm = new pair[n];
        pair[] both = new pair[n];
        
        

        DJUS dj = new DJUS(n);
        int count = 0;
        men = tmen;
        wm = twm;
        while (queue.size() > 0) {
            WeightedGraph temp = queue.poll();
            System.out.println(temp.x + " " + temp.y + " " + dj.root(temp.x) + " " + dj.root(temp.y) + " " + temp.weight);
            if (dj.root(temp.x) == dj.root(temp.y)) {
                continue;
            }
            if (temp.weight == 3) {
                dj.union(temp.x, temp.y);
                ++count;
            }

        }

        System.out.println(count + " " + men + " " + wm + " " + tmen + " " + n + " " + tot);
        // System.out.println(count);
        System.out.println(n - count + men + wm);
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

class pair{
    int x;
    int y;
    
    pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

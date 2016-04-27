/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeJam.J2010;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author jaimin
 */
public class ProblemA {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int n = in.readInt();
        for (int k = 1; k <= n; k++) {
            int c = in.readInt();
            int i = in.readInt();
            Store[] p = new Store[i];
            for (int j = 0; j < i; j++) {
                p[j] = new Store(in.readInt(), j + 1);
            }

            Arrays.sort(p, new Comparator<Store>() {

                @Override
                public int compare(Store o1, Store o2) {
                    return o1.price - o2.price;
                }
            }
            );

            int last = i - 1;
            int j = 0;
            while (true) {
                if (p[j].price + p[last].price > c) {
                    --last;
                } else if (p[j].price + p[last].price < c) {
                    ++j;
                } else {
                    if (p[j].index < p[last].index) {
                        out.println("Case #" + k + ": " + p[j].index + " " + p[last].index);
                    } else {
                        out.println("Case #" + k + ": " + p[last].index + " " + p[j].index);
                    }
                    break;
                }
            }

        }

        out.flush();
        out.close();
    }

    static class Store {

        int price;
        int index;

        Store(int price, int index) {
            this.price = price;
            this.index = index;
        }
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

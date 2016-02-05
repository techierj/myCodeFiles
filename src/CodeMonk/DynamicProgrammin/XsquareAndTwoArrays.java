/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeMonk.DynamicProgrammin;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 *
 * @author jaimin
 */
public class XsquareAndTwoArrays {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int n = in.readInt() + 1;
        int q = in.readInt();

        long[] A = new long[n];
        long[] B = new long[n];

        for (int i = 1; i < n; i++) {
            if (i > 1) {
                A[i] = in.readLong() + A[i - 2];
            } else {
                A[i] = in.readLong();
            }
        }
        for (int i = 1; i < n; i++) {
            if (i > 1) {
                B[i] = in.readLong() + B[i - 2];
            } else {
                B[i] = in.readLong();
            }
        }

        while (q-- > 0) {
            int type = in.readInt();
            int l = in.readInt();
            int r = in.readInt();

            if (((l + r) & 1) == 0) {
                if (type == 1) {
                    if (l > 1) {
                        out.println(A[r] - A[l - 2] + B[r - 1] - B[l - 1]);
                    } else {
                        out.println(A[r] + B[r - 1]);
                    }
                } else {
                    if (l > 1) {
                        out.println(B[r] - B[l - 2] + A[r - 1] - A[l - 1]);
                    } else {
                        out.println(B[r] + A[r - 1]);
                    }
                }
            } else {
                if (type == 1) {
                    if (l > 1) {
                        out.println(B[r] - B[l - 1] + A[r - 1] - A[l - 2]);
                    } else {
                        out.println(B[r] + A[r - 1]);
                    }
                } else {
                    if (l > 1) {
                        out.println(A[r] - A[l - 1] + B[r - 1] - B[l - 2]);
                    } else {
                        out.println(A[r] + B[r - 1]);
                    }
                }
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

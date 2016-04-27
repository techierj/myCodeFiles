/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 *
 * @author jaimin
 */
public class FunnyOperations {

    static long max;
    static long len;

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int t = in.readInt();
        while (t-- > 0) {
            max = 0;
            len = 0;
            int n = in.readInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.readLong();
            }
            for (int i = 1; i <= n; i++) {
                count(arr, n, i);
            }
            out.println(max + " " + len);
        }
        out.flush();
        out.close();
    }

    static void count(long arr[], int n, int r) {
        long subSet[] = new long[r];
        combo(arr, subSet, 0, n - 1, 0, r);
    }

    static void combo(long arr[], long subSet[], int start,
            int end, int index, int r) {
        if (index == r) {
            long and = Long.MAX_VALUE+1;
            long xor = 0;
            for (int j = 0; j < r; j++) {
                and = and & subSet[j];
                xor = xor ^ subSet[j];
            }
            long or = and | xor;
            if (or >= max) {
                max = or;
                if (len < r) {
                    len = r;
                }
            }
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            subSet[index] = arr[i];
            combo(arr, subSet, i + 1, end, index + 1, r);

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

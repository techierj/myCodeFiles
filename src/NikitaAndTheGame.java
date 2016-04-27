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
public class NikitaAndTheGame {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int t = in.readInt();
        while (t-- > 0) {
            int n = in.readInt() + 1;
            long[] arr = new long[n];
            long[] arr2 = new long[n];
            for (int i = 1; i < n; i++) {
                arr[i] = arr[i - 1] + in.readLong();
            }
            for (int i = 1; i < n; i++) {
                arr2[i] = arr[n - i] - arr[n - i - 1] + arr2[i - 1];
                //out.print(arr2[i]+" ");
            }
            long left = 0;
            long lastL = arr[n - 1];
            int leftPost = 1;
            int RightPost = n - 1;
            long right = 0;
            long lastR = arr[n - 1];

            --n;
            int count = 0;
            int count2 = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i] - left == lastL - arr[i]) {
                    if (leftPost > RightPost - leftPost) {
                        RightPost = i;
                        lastL = arr[i];
                        n = i;
                        i = 1;
                    } else {
                        leftPost = i;
                        left = arr[i];
                    }
                    ++count;
                }
                if (arr2[i] - right == lastR - arr2[i]) {
                    right = arr2[i];
                    ++count2;
                    out.print(arr2[i] + " " + right + " , ");
                }
                //out.print(arr[i]+" "+(lastL-arr[i])+" , ");
            }
            count = count > count2 ? count : count2;
            out.println(count);
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

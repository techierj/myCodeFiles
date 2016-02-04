/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank.DynamicProgrammin;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author jaimin
 */
public class MakingChange {

    static int[] coins;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);

        int n = in.readInt();
        int m = in.readInt();
        coins = new int[m];

        for (int i = 0; i < m; i++) {
            coins[i] = in.readInt();
        }

        MakingChange obj = new MakingChange();

        System.out.print(obj.countChange(n, m));

    }

    int countChange(int n, int m) {
        int[][] arr = new int[n + 1][m];

        for (int i = 0; i < m; i++) {
            arr[0][i] = 1;
        }
        ++n;
        int x, y, temp;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp = i - coins[j];
                if (temp >= 0) {
                    x = arr[i - coins[j]][j];
                } else {
                    x = 0;
                }
                if (j > 0) {
                    y = arr[i][j - 1];
                } else {
                    y = 0;
                }
                arr[i][j] = x + y;
            }
        }
        /*
         for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
         System.out.print(arr[i][j]+" ");
         }
         System.out.println();
         }*/

        return arr[n - 1][m - 1];
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

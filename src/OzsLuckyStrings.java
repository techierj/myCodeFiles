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
public class OzsLuckyStrings {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int t = in.readInt();

        while (t-- > 0) {
            String s = in.readString();
            int n = s.length();
            int[] r = new int[n];
            int[] k = new int[n];
            int j = n - 2;
            if (s.charAt(0) == 'R') {
                r[0] = 1;
            }
            if (s.charAt(n - 1) == 'K') {
                k[n - 1] = 1;
            }
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == 'R') {
                    r[i] = r[i - 1] + 1;
                } else {
                    r[i] = r[i - 1];
                }

                if (s.charAt(n - i - 1) == 'K') {
                    k[n-1-i] = k[n-i] + 1;
                } else {
                    k[n-1-i] = k[n-i];
                }
                
                

            }
            int i = 0, ans = 0;

            for (; i < n; i++) {
                if(r[i]>=k[i]){
                    int tmp=r[i]<k[i]?r[i]:k[i];
                    if(tmp>ans){
                        ans=tmp;
                    }
                }
                //out.print(r[i] + " " + k[i] + " , ");
            }

            out.println(ans<<1);
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

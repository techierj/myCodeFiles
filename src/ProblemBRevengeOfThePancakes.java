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
public class ProblemBRevengeOfThePancakes {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int t = in.readInt();
        for (int k = 1; k <= t; k++) {
            String s = in.readString();
            int len = s.length();
            int flip = 0;
            boolean flg = false;
            for (int i = len - 1; i >= 0;) {
                flg = false;
                if (flip % 2 == 0 && s.charAt(i) == '-') {
                    while (i >= 0 && s.charAt(i) == '-') {
                        //s.setCharAt(i, '+');
                        --i;
                        
                    }
                    //out.println(s+" "+flip);
                    ++flip;
                    flg = true;
                }

                if (flip % 2 == 1 && i >= 0 && s.charAt(i) == '+') {
                    while (i >= 0 && s.charAt(i) == '+') {
                        //s.setCharAt(i, '-');
                        --i;
                    }
                    //out.println(s+" "+flip);
                    ++flip;
                    flg = true;
                }
                if(!flg){
                    --i;
                }
            }

            out.println("Case #" + k + ": " + flip);
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
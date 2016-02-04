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
public class CloneEmUp {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int t = in.readInt();
        while (t-- > 0) {
            int n = in.readInt();
            long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE, max4 = Long.MIN_VALUE;
            long min1 = Long.MAX_VALUE, min2 = Long.MAX_VALUE, min3 = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                long temp = in.readLong();
                if (temp > max4) {
                    max1 = max2;
                    max2 = max3;
                    max3 = max4;
                    max4 = temp;
                } else if (temp > max3) {
                    max1 = max2;
                    max2 = max3;
                    max3 = temp;
                } else if (temp > max2) {
                    max1 = max2;
                    max2 = temp;
                    
                } else if (temp > max1) {
                    max1 = temp;
                }

                if (temp < min1) {
                    min3 = min2;
                    min2 = min1;
                    min1 = temp;
                } else if (temp < min2) {
                    min3 = min2;
                    min2 = temp;
                } else if (temp < min3) {
                    min3 = temp;
                }
                //out.println(max1 + " " + max2 + " " + max3 + " " + max4);
            }
            
            out.println((max1 * min3) % 10000009);
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

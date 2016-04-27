/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jaimin
 */
public class ExpandIt {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        String s = in.readString();
        int l = s.length();
        BigInteger total = new BigInteger("0");
        BigInteger[] arr = new BigInteger[26];

        for (int i = 0; i < 26; i++) {
            arr[i] = new BigInteger("0");
        }
        String tempCount = "";
        int c = 0;
        for (int i = 0; i < l;) {

            char tempC = s.charAt(i);
            tempCount="";
            c = (int) (tempC - 'a');
            ++i;
            while (true) {
                if (i < l) {
                    tempC = s.charAt(i);
                    if ((tempC >= '0' && tempC <= '9') && i < l) {
                        tempCount += s.charAt(i);
                        ++i;
                    } else {
                        BigInteger temp = new BigInteger(tempCount);
                        arr[c] = arr[c].add(temp);
                        total = total.add(temp);
                        break;
                    }

                } else {
                    BigInteger temp = new BigInteger(tempCount);
                    arr[c] = arr[c].add(temp);
                    total = total.add(temp);
                    break;
                }
            }

        }
        long q = in.readLong();
        while (q-- > 0) {
            String strK = in.readString();
            BigInteger k = new BigInteger(strK);
            if (k.compareTo(total) > 0) {
                out.println("-1");
            } else {
                BigInteger tempTotal = new BigInteger("0");
                int i = 0;
                while (tempTotal.compareTo(k) < 0) {
                    tempTotal = tempTotal.add(arr[i++]);
                }
                out.println((char) (i + 'a' - 1));
            }
        }

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

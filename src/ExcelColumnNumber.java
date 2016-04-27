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
public class ExcelColumnNumber {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out, true);
        InputReader in = new InputReader(System.in);

        out.println(reverse(-123));
        out.close();
    }

    static int reverse(int a) {
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        try {
            if (a < 0) {
                a*=-1;
                sb.append(a);
                sb.reverse();
                return Integer.parseInt(sb.toString()) * -1;
            } else {
                sb.append(a);
                sb.reverse();
                return Integer.parseInt(sb.toString());
            }
        } catch (Exception e) {
            return 0;
        }
    }

    static boolean isPalindrome(int a) {
        String s = "" + a;
        int len = s.length();
        int mid = len >> 1;
        --len;
        for (int i = 0; i < mid; i++) {
            if (s.charAt(i) != s.charAt(len - i)) {
                return false;
            }
        }

        return true;
    }

    static String ColumnName(int a) {
        String ans = "";

        while (a > 0) {
            int rem = a % 26;
            if (rem == 0) {
                ans = 'Z' + ans;
                a = (a / 26) - 1;
            } else {
                ans = ((char) (64 + (a % 26))) + ans;
                a /= 26;
            }
        }

        return ans;
    }

    static int titleToNumber(String a) {
        int ans = 0;

        int len = a.length();
        int val = 1;
        for (int i = len - 1; i >= 0; i--) {
            int num = a.charAt(i) - 'A' + 1;
            ans += (val * num);
            val *= 26;

        }

        return ans;
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

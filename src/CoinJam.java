/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author jaimin
 */
public class CoinJam {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out, true);
        InputReader in = new InputReader(System.in);

        int t = in.readInt();
        outer:
        for (int k = 1; k <= t; k++) {

            HashSet<String> set = new HashSet<>();
            int n = in.readInt();
            int j = in.readInt();
            out.println("Case #" + k + ":");
            String s = "1";
            for (int i = 2; i < n; i++) {
                s += "0";
            }
            s += "1";
            long start = Long.parseLong(s, 2);

            String s2 = "1";
            for (int i = 2; i < n; i++) {
                s2 += "1";
            }
            s2 += "1";
            long end = Long.parseLong(s2, 2);
            Random random = new Random();
            long diff = end - start + 1;
            while (j > 0) {
                long nextNum = start + (long) (Math.random() * (diff));

                //System.out.println(z);
                int count = 0;
                String binary = Long.toString(nextNum, 2);
                s = binary;
                if (s.charAt(0) == '0' || s.charAt(n - 1) == '0') {
                    continue;
                } else {
                    if (!set.contains(binary)) {
                        set.add(binary);
                    } else {
                        while (true) {
                            nextNum += 1;
                            if (nextNum > end) {
                                nextNum = start;
                            }
                            binary = Long.toString(nextNum,2);
                            if (s.charAt(0) == '0' || s.charAt(n - 1) == '0') {
                                continue;
                            } else if(!set.contains(binary)){
                                set.add(binary);
                                break;
                            }

                        }
                        for (int y = 2; y <= 10; y++) {

                            BigInteger num = new BigInteger(binary, y);
                            //long num = Long.parseLong(binary, y);
                            BigInteger x = new BigInteger("2");
                            boolean flg = false;

                            BigInteger upto = sqrt(num);
                            while (x.compareTo(upto) != 0) {
                                //for (; x <= upto; ) {
                                if (num.mod(x).compareTo(new BigInteger("0")) == 0) {
                                    //if (num % x == 0) {
                                    flg = true;
                                    break;
                                }
                                x = x.add(new BigInteger("1"));
                            }

                            if (flg) {

                                s += " " + x;
                                ++count;
                            } else {
                                break;
                            }

                            if (count == 9) {
                                out.println(s);
                                out.flush();
                                --j;
                            }
                        }

                    }
                }
            }

            out.close();
        }
    }

    static BigInteger sqrt(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
        while (b.compareTo(a) >= 0) {
            BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
            if (mid.multiply(mid).compareTo(n) > 0) {
                b = mid.subtract(BigInteger.ONE);
            } else {
                a = mid.add(BigInteger.ONE);
            }
        }
        return a.subtract(BigInteger.ONE);
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

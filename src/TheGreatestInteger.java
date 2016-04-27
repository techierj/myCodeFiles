/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author jaimin
 */
public class TheGreatestInteger {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int n = in.readInt();

        int min = Integer.MAX_VALUE;
        int max = 0;
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> genVal = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            int cur = in.readInt();
            if (cur < min) {
                min = cur;
            }
            if(cur>max){
                max = cur;
            }
            set.add(cur);
            genVal.add(cur);
        }
        int m = in.readInt();
        while (!genVal.isEmpty()) {
            int first = genVal.remove(0);
            if (first != min) {
                int rem = Math.abs(first - min);
                if (!set.contains(rem)) {
                    genVal.add(rem);
                    set.add(rem);
                    if (rem < min) {
                        min = rem;
                        int dif = max - min;
                        if (!set.contains(dif)) {
                            genVal.add(dif);
                            set.add(dif);
                        }
                    }
                }
            }
            if (first != max) {
                int rem = Math.abs(first - max);
                if (!set.contains(rem)) {
                    genVal.add(rem);
                    set.add(rem);
                    if (rem > max) {
                        max = rem;
                        int dif = max - min;
                        if (!set.contains(dif)) {
                            genVal.add(dif);
                            set.add(dif);
                        }
                    }
                }
            }
        }

        List<Integer> arr = new ArrayList<>();
        arr.addAll(set);
        Collections.sort(arr);

        out.println(arr.get(arr.size() - m));
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

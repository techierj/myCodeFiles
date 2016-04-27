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
public class MillyAndHerClassmates {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out, true);
        InputReader in = new InputReader(System.in);

        int t = in.readInt();
        outer:
        while (t-- > 0) {
            int n = in.readInt() + 1;
            long[] arr = new long[n];
            boolean flg = false,prv=false;
            for (int i = 1; i < n; i++) {
                arr[i] = in.readLong();
                if (flg == true && !prv && arr[i] < arr[i - 1]) {
                    out.println("-1 -1");
                    continue outer;
                } else if (arr[i] < arr[i - 1]) {
                    flg = true;
                    prv=true;
                }else if(arr[i]>arr[i-1]){
                    prv=false;
                }
            }

            if (!flg) {
                out.println("-1 -1");
            } else {
                int pos = 0;
                for (int i = 1; i < n; i++) {
                    flg = false;
                    if (arr[i] < arr[i - 1]) {
                        pos = i - 1;
                        flg = true;
                    }
                    if (flg) {
                        while (i < n && arr[i] < arr[i - 1]) {
                            i++;
                        }
                        
                        if (pos > 1) {
                            if (arr[pos - 1] < arr[i-1]) {
                                out.println(pos + " " + (i-1));
                            } else {
                                out.println("-1 -1");
                            }
                        } else {
                            out.println(pos + " " + (i-1));
                        }
                    }
                }
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

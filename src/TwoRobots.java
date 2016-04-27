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
public class TwoRobots {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int t = in.readInt();
        while (t-- > 0) {
            int m = in.readInt();
            int n = in.readInt();

            boolean r1 = false, r2 = false;
            long total = 0;
            int r1Last = 0, r2Last = 0;
            while (n-- > 0) {
                int Ma = in.readInt();
                int Mb = in.readInt();
                if (r1 == false) {
                    total += (int) Math.abs(Mb - Ma);
                    r1Last = Mb;
                    r1 = true;
                } else if (r2 == false) {
                    int r1Dis = Math.abs(r1Last - Ma);
                    int r1temp = Math.abs(Ma - Mb) + r1Dis;
                    int r2temp = Math.abs(Mb - Ma);
                    if (r1temp <= r2temp || Mb==r1Last) {
                        total += r1temp;
                        r1Last = Mb;
                    } else{
                        total += r2temp;
                        r2Last = Mb;
                        r2 = true;
                    }
                } else {
                    int r1Dis = Math.abs(r1Last - Ma);
                    int r1temp = Math.abs(Ma - Mb) + r1Dis;
                    int r2Dis = Math.abs(r2Last - Ma);
                    int r2temp = Math.abs(Ma - Mb) + r2Dis;
                    if (r1temp <= r2temp || Mb==r1Last) {
                        total += r1temp;
                        r1Last = Mb;
                    } else {
                        total += r2temp;
                        r2Last = Mb;
                    }
                }
                //out.println(r1Last + " :r1Last " + r2Last + " :r2Last "+total+" :total");
            }
            out.println(total);
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

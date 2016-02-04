/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeMonk.GreedyAlgorithm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 *
 * @author jaimin
 */
public class TheLegendOfTanmay {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        int t = in.readInt();

        while (t-- > 0) {
            int n = in.readInt();
            int[] arr = new int[n];
            int nag = 0;
            int pos = 0;
            long max = 1;
            long min = 1;
            long smallest = Long.MIN_VALUE;
            long smallestPos = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                arr[i] = in.readInt();
                if (arr[i] > 0) {
                    ++pos;
                    max = (long) max * arr[i];
                    if (arr[i] < smallestPos) {
                        smallestPos = arr[i];
                    }
                } else if (arr[i] < 0) {
                    ++nag;
                    min = (long) min * arr[i];
                    if (arr[i] > smallest) {
                        smallest = arr[i];
                    }

                }
            }
            if (pos == 0 && nag == 0) {
                sb.append("0 0\n");
                continue;
            }
            if (pos == 0) {
                if (nag > 1) {
                    if (nag % 2 == 0) {
                        long temp = max;
                        max = (long) max * min;
                        min = (long) temp * (min / (smallest));
                    } else {
                        long temp = max;
                        max = (long) max * (min / (smallest));
                        min = (long) temp * min;
                    }
                    sb.append(max + " " + min + "\n");
                    continue;
                } else if (nag == 1 && n == nag) {
                    max = min;
                    sb.append(max + " " + min + "\n");
                    continue;
                } else {
                    max = 0;
                    sb.append(max + " " + min + "\n");
                    continue;
                }
            }
            if (nag == 0) {
                if (pos < n) {
                    min = 0;
                    sb.append(max + " " + min + "\n");
                    continue;
                } else {
                    min = smallestPos;
                }
            }

            //System.out.println(smallest+" , "+smallestPos);
            if (pos != 0 && nag != 0) {
                if (nag % 2 == 0) {
                    long temp = max;
                    max = (long) max * min;
                    min = (long) temp * (min / (smallest));

                } else {
                    long temp = max;
                    max = (long) max * (min / (smallest));
                    min = (long) temp * min;
                }
            }

            sb.append(max + " " + min + "\n");
        }

        System.out.print(sb);

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

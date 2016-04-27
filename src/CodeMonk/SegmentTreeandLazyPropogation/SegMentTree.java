/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeMonk.SegmentTreeandLazyPropogation;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author jaimin
 */
public class SegMentTree {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int n = in.readInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.readLong() & 1;
        }

        SegmentTreeSum st = new SegmentTreeSum(arr, n);
        //arr = null;
        int q = in.readInt();
        while (q-- > 0) {
            int qt = in.readInt();
            int q1 = in.readInt();

            if (qt == 0) {
                long q2 = in.readLong() & 1;
                st.updateValue(arr, n, q1 - 1, q2);
            } else if (qt == 1) {
                int q2 = in.readInt();
                long odd = st.getSum(n, q1 - 1, q2 - 1);
                out.println(1 + q2 - q1 - odd);
            } else {
                int q2 = in.readInt();
                long even = st.getSum(n, q1 - 1, q2 - 1);
                out.println(even);
            }
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

class SegmentTreeSum {

    long[] st;

    SegmentTreeSum(long[] arr, int n) {

        //height of segment tree
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        //Maximum size of segmetn tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        st = new long[max_size];
        //System.out.println(max_size);
        build(arr, 0, n - 1, 0);
    }

    long build(long[] arr, int start, int end, int index) {
        if (start == end) {
            st[index] = arr[start];
            return arr[start];
        } else {
            int mid = getMid(start, end);
            st[index] = build(arr, start, mid, index * 2 + 1)
                    + build(arr, mid + 1, end, index * 2 + 2);
            return st[index];
        }
    }

    int getMid(int start, int end) {
        return start + (end - start) / 2;
    }

    void updateValue(long arr[], int n, int i, long newVal) {
        if (i < 0 || i > n - 1) {
            return;
        }
        long diff = newVal - arr[i];
        arr[i] = newVal;

        updateSubTree(0, n - 1, i, diff, 0);
    }

    void updateSubTree(int start, int end, int i, long diff, int index) {
        if (i < start || i > end) {
            return;
        }
        st[index] = st[index] + diff;
        if (end != start) {
            int mid = getMid(start, end);
            updateSubTree(start, mid, i, diff, 2 * index + 1);
            updateSubTree(mid + 1, end, i, diff, 2 * index + 2);
        }
    }

    //qs = query start, qe = query end
    long getSum(int n, int qs, int qe) {
        if (qs < 0 || qe > n - 1 || qs > qe) {
            return -1;
        }
        return countSum(0, n - 1, qs, qe, 0);
    }

    long countSum(int start, int end, int qs, int qe, int index) {
        if (qs <= start && qe >= end) {
            return st[index];
        }
        if (end < qs || start > qe) {
            return 0;
        }

        int mid = getMid(start, end);
        return countSum(start, mid, qs, qe, 2 * index + 1) + countSum(mid + 1, end, qs, qe, 2 * index + 2);
    }

    long RMQ(int n, int qs, int qe) {
        if (qs < 0 || qe > n - 1 || qs > qe) {
            return -1;
        }
        return RMQMinCount(0, n - 1, qs, qe, 0);
    }

    long RMQMinCount(int start, int end, int qs, int qe, int index) {
        if (qs <= start && qe >= end) {
            return st[index];
        }
        if (end < qs && start > qe) {
            return Long.MAX_VALUE;
        }

        int mid = getMid(start, end);
        return minVal(RMQMinCount(start, mid, qs, qe, 2 * index + 1), RMQMinCount(mid + 1, end, qs, qe, 2 * index + 2));
    }

    long minVal(long a, long b) {
        return a < b ? a : b;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank.BasicStatistics;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 *
 * @author jaimin
 */
public class Day1BasicStatisticsAWarmup {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int n = in.readInt();
        int[] arr = new int[n];
        double mean = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.readInt();
            mean += arr[i];
        }

        mean = mean / n;

        Arrays.sort(arr);

        double median = 0;
        if (n % 2 == 0) {
            median = (arr[n >> 1] + (arr[(n >> 1) - 1])) / 2.0;
        } else {
            median = arr[(n >> 1)+1];
        }

        
        int num = 0;
        int max = -1;
        int mod = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                ++num;
            } else {
                if (num > max) {
                    max = num;
                    mod = arr[i - 1];
                    num = 0;
                }
            }
        }
        
        double SD = 0;
        double variation = 0;
        for(int i=0;i<n;i++){
            variation+=Math.pow(arr[i]-mean,2);
        }
        
        SD = Math.sqrt(variation/n);
       
        DecimalFormat df = new DecimalFormat("#0.#");
        
        out.println(df.format(mean));
        out.println(df.format(median));
        out.println(mod);
        out.println(df.format(SD));
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

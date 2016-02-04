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
public class FlatlandSpaceStations {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int n = in.readInt();
        int m = in.readInt();

        if(n==m){
            out.println(0);
            out.flush();
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            arr[in.readInt()] = 0;
        }
        boolean frst = false,last = false;
        for (int i = 0; i < n; i++) {
            if (frst && arr[i] != 0) {
                if (arr[i] > 0) {
                    arr[i] = Math.min(arr[i - 1] + 1, arr[i]);
                } else {
                    arr[i] = arr[i - 1] + 1;
                }
            }else if (!frst && arr[i] == 0) {
                frst = true;
            }
            
            if (arr[n-1-i] != 0 && last) {
                if (arr[n-1-i] > 0) {
                    arr[n-1-i] = Math.min(arr[n-i] + 1, arr[n-i-1]);
                } else {
                    arr[n-1-i] = arr[n-i] + 1;
                }
            }else if (!last && arr[n-1-i] == 0) {
                last = true;
            }
            
        }
        int max = 0;
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        /*
        for(int tem:arr){
            out.print(tem+" ");
        }*/
        out.println(max);
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

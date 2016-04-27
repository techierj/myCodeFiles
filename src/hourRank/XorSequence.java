/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hourRank;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 *
 * @author jaimin
 */
public class XorSequence {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int temp = 0;

        for (int i = 1; i < 100; i++) {
            temp ^= i;
            out.println(temp + " " + i);
        }
        int q = in.readInt();

        while (q-- > 0) {
            long prv = 0;
            long ans = 0;
            long l = in.readLong();
            long r = in.readLong();
            long i = l;

            if (i % 2 == 0) {
                if (i % 4 == 0) {
                    prv = i;
                } else {
                    prv = i + 1;
                }
            } else {
                if (i % 4 == 3) {
                    prv = 0;
                } else {
                    prv = 1;
                }
            }
            ans = prv;
            //out.print(prv+" ");
            for (i = l+1; i <= r; i++) {
                
                if(prv==0){
                    prv = i;
                }else if(prv==1){
                    prv = i+1;
                }else if(prv==i+1){
                    prv = 0;
                }else{
                    prv = 1;
                }
                //out.print(prv+" : "+l+" , ");
                ans ^= prv;
            }

            out.println(ans);
        }
        
        out.println(3^8);
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

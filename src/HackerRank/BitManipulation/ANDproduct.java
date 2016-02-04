/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank.BitManipulation;

import com.oracle.jrockit.jfr.ContentType;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author jaimin
 */
public class ANDproduct {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);

        //System.out.println(11 & 12 & 13 & 14);

        //System.out.println(log2(11) + " " + log2(15) + " " + count(12) + " " + count(15));

        int t = in.readInt();
        while (t-- > 0) {
            long a = in.readLong();
            long b = in.readLong();

            if (log2(a) != log2(b)) {
                System.out.println("0");
            } else {
                String sA = Long.toBinaryString(a);
                String sB = Long.toBinaryString(b);
                String temp = "";

                int lenA = sA.length();
                int lenB = sB.length();
                int min = lenA < lenB ? lenA : lenB;

                for (int i = 0; i < min; i++) {
                    if (sA.charAt(i) == sB.charAt(i)) {
                        temp += sA.charAt(i);
                    }else{
                        break;
                    }
                }

                if (temp.length() == lenB || temp.length()==lenA) {
                    System.out.println(a);
                } else {
                    int max = lenA > lenB ? lenA : lenB;

                    for (int i = temp.length(); i < max; i++) {
                        temp += "0";
                    }
                    System.out.println(Long.parseLong(temp, 2));
                }
            }
            /*
             for(long i=a;i<=b;i++){
             System.out.println(Long.toBinaryString(i));
             }*/

            /*
             int t = in.readInt();
             while(t-->0){
             long a = in.readLong();
             long b = in.readLong();
             sb.append(a+"\n");
             }*/
            //System.out.print(sb);

        }
    }

    static int log2(long a) {
        return (int) (Math.log(a) / Math.log(2));
    }

    static int count(long n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            ++count;
        }
        return count;
    }

    static long nearestPower(long a) {
        a = a | (a >> 1);
        a = a | (a >> 2);
        a = a | (a >> 4);
        a = a | (a >> 8);
        a = a | (a >> 16);
        a = a | (a >> 32);

        return (long) (a + 1) >> 1;
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

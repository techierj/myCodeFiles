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
abstract class abc{
    abstract String name();
    String name2(){
        return "jaimin";
    }
}
public class uCanDoIt {

    public static void main(String[] args) throws IOException, InterruptedException {
        PrintWriter out = new PrintWriter(System.out, true);
        InputReader in = new InputReader(System.in);
        //while (true) {
            for (int i = 0; i < 2; i++) {
                System.out.println("UUU    UUU    CCCCCCCCCC  AAAAAAAAAA NNN    NNN    DDDDDDDDDD  OOOOOOOOOO    IIIIIIIIII  TTTTTTTTTT");
            }

            for (int i = 0; i < 2; i++) {
                System.out.println("UUU    UUU    CCC         AAA    AAA NNNN   NNN    DDD     DD  OOO    OOO       IIII        TTTT   ");
            }
            for (int i = 0; i < 2; i++) {
                System.out.println("UUU    UUU    CCC         AAAAAAAAAA NN NN  NNN    DDD     DD  OOO    OOO       IIII        TTTT   ");
            }
            for (int i = 0; i < 2; i++) {
                System.out.println("UUU    UUU    CCC         AAA    AAA NN  NN NNN    DDD     DD  OOO    OOO       IIII        TTTT   ");
            }

            for (int i = 0; i < 2; i++) {
                System.out.println("UUUUUUUUUU    CCCCCCCCCC  AAA    AAA NN   NNNNN    DDDDDDDDDD  OOOOOOOOOO    IIIIIIIIII     TTTT   ");
            }
            String s = "UUUUUUUUUU    CCCCCCCCCC  AAA    AAA NN   NNNNN    DDDDDDDDDD  OOOOOOOOOO    IIIIIIIIII     TTTT   ";
            
            Thread.sleep(2000);
            for(int i=0;i<10;i++){
                Thread.sleep(100);
                System.out.print("\033[2K");
            }
        //}
        //out.close();
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

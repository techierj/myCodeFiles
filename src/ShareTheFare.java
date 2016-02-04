/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author jaimin
 */
public class ShareTheFare {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int t = in.readInt();
        while (t-- > 0) {
            Map<String, Long> trans = new LinkedHashMap<String, Long>();

            int n = in.readInt();
            int q = in.readInt();

            while (n-- > 0) {
                trans.put(in.readString(), (long)0);
            }
            while (q-- > 0) {
                String name = in.readString();
                long pay = in.readInt();
                int k = in.readInt()+1;
                long r = (int) Math.floor(pay / k);
                //System.out.println(r+"--");
                
                if(k*r<pay)
                    trans.put(name, trans.get(name) - (pay)+r+(pay%k));
                else{
                    trans.put(name, trans.get(name) - (pay)+r);
                }
                while (k-- > 1) {
                    String name2 = in.readString();
                    trans.put(name2, trans.get(name2) + r);
                }
            }
            
            
            
            Set s = trans.entrySet();
            Iterator it = s.iterator();
            while (it.hasNext()) {
                Map.Entry me = (Map.Entry)it.next();
                if((long)me.getValue()>0){
                    out.println(me.getKey()+" owes "+me.getValue());
                }else if((long)me.getValue()<0){
                    long tempVal = (long)me.getValue()*(-1);
                    out.println(me.getKey()+" is owed "+tempVal);
                }else{
                    out.println(me.getKey()+" neither owes nor is owed");
                }
            }
        }

        out.flush();
    }
    
    class Node{
        int val;
        int pos;
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

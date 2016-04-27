/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author jaimin
 */
public class GroupBooking {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int f = in.readInt();
        long room = in.readLong();

        List<Integer> fb = new ArrayList<Integer>();

        for (int i = 0; i < f; i++) {
            fb.add(in.readInt());
        }
        Collections.sort(fb);
        List<Node> hotel = new ArrayList<Node>();
        for (long i = 0; i < room; i++) {
            int price = in.readInt();
            int cap = in.readInt();
            if (price < 100001) {
                hotel.add(new Node(price, cap));
            }
        }
        Collections.sort(hotel, new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                if(o1.cap==o2.cap){
                    return o1.price-o2.price;
                }
                return o2.cap - o1.cap;
            }
        });

        Node temp = hotel.remove(0);
        int cap = temp.cap;
        int ans = 0;
        int i = 0;
        while (!fb.isEmpty()) {
            int size = fb.size() - 1;
            int j = size;
            while (cap > 0 && j >= 0) {
                
                //out.println(fb.get(j)+" "+temp.price);
                if (temp.price <= fb.get(j)) {
                    fb.remove(j);
                    cap--;
                }
                --j;
            }
            out.print(temp.price+" ");
            temp = hotel.remove(0);
            cap = temp.cap;
            ++ans;
        }
        out.println(ans);
        out.flush();
        out.close();
    }

    static class Node {

        int price;
        int cap;

        Node(int price, int cap) {
            this.price = price;
            this.cap = cap;
        }
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

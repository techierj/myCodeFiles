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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author jaimin
 */
public class SecretMessageGroups {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out, true);
        InputReader in = new InputReader(System.in);

        int n = in.readInt();
        HashMap<String, Group> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        ArrayList<String> arrList = new ArrayList<>();
        int groups = 0;

        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] arr = new int[10];
            String s = in.readString();
            int len = s.length();
            for (int j = 0; j < len; j++) {
                ++arr[Character.getNumericValue(s.charAt(j))];
            }
            String key = "";
            for (int j = 0; j < 10; j++) {
                key += arr[j] + " ";
            }
            if (!set.contains(s)) {
                if (map.containsKey(key)) {
                    Group g = map.get(key);
                    ++g.count;
                    g.list.add(s);
                    if (g.count > max) {

                        max = g.count;
                        arrList = new ArrayList<>();

                        StringBuilder sb = new StringBuilder();
                        for (String temp : g.list) {
                            sb.append(temp + " ");
                        }
                        arrList.add(sb.toString());

                    } else if (g.count == max) {
                        StringBuilder sb = new StringBuilder();
                        for (String temp : g.list) {
                            sb.append(temp + " ");
                        }
                        arrList.add(sb.toString());

                    }
                    map.put(key, g);
                } else {
                    ++groups;
                    Group g = new Group();
                    g.val = key;
                    g.count = 1;
                    g.list.add(s);
                    if (g.count > max) {

                        max = g.count;
                        arrList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (String temp : g.list) {
                            sb.append(temp + " ");
                        }
                        arrList.add(sb.toString());

                    } else if (g.count == max) {
                        StringBuilder sb = new StringBuilder();
                        for (String temp : g.list) {
                            sb.append(temp + " ");
                        }
                        arrList.add(sb.toString());

                    }

                    map.put(key, g);
                }
                set.add(s);
            }
        }

        out.println(groups);
        int size = arrList.size();

        ArrayList<String> sorted = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String[] asc = arrList.get(i).split(" ");
            Arrays.sort(asc,Collections.reverseOrder());
            int len = asc.length;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                sb.append(asc[j]+" ");
            }
            sorted.add(sb.toString());
        }
        Collections.sort(sorted);
        for(int i=0;i<size;i++){
            out.println(sorted.get(i));
        }
        out.close();
    }

    static class Group {

        String val;
        int count;
        ArrayList<String> list = new ArrayList<>();

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

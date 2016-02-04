
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jaimin
 */
public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String s = in.readString();

        CandidateCode obj = new CandidateCode();
        out.print(obj.constructTree(s));

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

class CandidateCode {

    public static String constructTree(String input1) {
        int len = input1.length();

        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        int totalChar = 0;
        for (int i = 0; i < len; i++) {
            if (hm.containsKey(input1.charAt(i))) {
                hm.put(input1.charAt(i), hm.get(input1.charAt(i)) +1);
            } else {
                hm.put(input1.charAt(i), 0);
                ++totalChar;
            }
        }

        Set<Entry<Character, Integer>> set = hm.entrySet();
        List<Entry<Character, Integer>> list = new ArrayList<Entry<Character, Integer>>(set);
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (o2.getValue() != o1.getValue()) {
                    return (o2.getValue()).compareTo(o1.getValue());
                }

                return o1.getKey().compareTo(o2.getKey());
            }
        });

        Map<Character,String> encode = new HashMap<Character,String>();
        String temp = "";
        int i=1;
        for (Map.Entry<Character, Integer> entry : list) {
            if(i==totalChar){
                encode.put(entry.getKey(), temp);
                //System.out.println(entry.getKey()+" = "+temp);
            }else{
                encode.put(entry.getKey(), temp+"0");
                //System.out.println(entry.getKey()+" = "+temp+"0");
            }
            temp+="1";
            ++i;
        }
        
        String output = "";
        for(i=0;i<len;i++){
            output += encode.get(input1.charAt(i));
        }
        //System.out.println(output);
        return output;
    }

}

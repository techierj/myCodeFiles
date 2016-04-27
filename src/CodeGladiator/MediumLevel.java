/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeGladiator;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author jaimin
 */
public class MediumLevel {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int input1 = 4;
        int input2[] = {2,1,1,0};
        out.println(uniqueValue(input1, input2));
        out.flush();
        out.close();
    }

    public static int[] uniqueValue(int input1, int[] input2) {
        int[] arr = new int[input1];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, input2[0]);
        arr[input2[0]] = 1;
        for (int i = 1; i < input1; i++) {
            int pos = -1;
            for (int j = 0; j < i; j++) {
                if (input2[j] <= input2[i]) {
                    pos = j;
                }
            }

            if (pos != -1) {
                //System.out.println(pos + " ." + map.get(pos + 1) + " , " + (input2[i] - input2[pos] + 1));
                if (map.containsKey(pos + 1)) {

                    int temp = map.get(pos + 1) + (input2[i] - input2[pos]) + 1;
                    //System.out.println(i + " " + input2[i] + " " + temp);
                    
                        int temp2 = input2[i];
                        for (int k = 0; k < input1; k++) {
                            if (arr[k] == 0) {
                                //System.out.println((i+1)+" "+k + " //" + input2[i] + " " + temp);
                                if (temp2 == 0) {
                                    arr[k] = i + 1;
                                    map.put(i + 1, k);
                                    arr[k] = i + 1;
                                    break;
                                } else {
                                    --temp2;
                                }
                            }
                        }
                    
                } else {
                    int temp = pos;
                    if (arr[temp] != 0) {
                        for (int k = temp; k < input1; k++) {
                            if (arr[k] == 0) {
                                arr[k] = i + 1;
                                map.put(i + 1, k);
                                arr[k] = i + 1;
                                break;
                            }
                        }
                    } else {
                        map.put(i + 1, temp);
                        arr[temp] = i + 1;
                    }

                }
            } else {
                int temp = input2[i];
                
                for (int j = 0; j < input1; j++) {
                    if (arr[j] == 0) {
                        
                        if (temp == 0) {
                            arr[j] = i + 1;
                            map.put(i + 1, j);
                            break;
                        } else {
                            --temp;
                        }
                    }
                }
            }

        }
/*
        for (int j : arr) {
            System.out.println(j + " ");
        }*/
        return arr;
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

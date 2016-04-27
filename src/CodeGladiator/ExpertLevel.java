/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeGladiator;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 *
 * @author jaimin
 */
class AB extends Thread {

    public void run() {
        while (true) {
            long threadId = Thread.currentThread().getId();
            System.out.println("Hello World ! " + threadId);
            //Sleep for sometime
        }
    }

    public void doSomething() {
        this.start();
    }
}

public class ExpertLevel {

    ExpertLevel() {
        System.out.println("d cons");
        return;
    }

    ExpertLevel(String s) {
        this();
        System.out.println("co");
        return;
    }

    public void ExpertLevel() {

    }

    public static void main(String[] args) throws IOException {
        ExpertLevel e = new ExpertLevel("Ja");
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int input1 = 6;
        int input2 = 3;
        int[] input3 = {3, 3, 7, 3, 1, 3, 4, 3, 1, 4, 2, 6, 4, 1, 4, 2, 4, 1};

        System.out.print(GetWaterLevel(input1, input2, input3));

        out.flush();
        out.close();
    }

    public static int GetWaterLevel(int input1, int input2, int[] input3) {
        int[][] arr = new int[input1][input2];
        int pos = 0;
        for (int i = 0; i < input1; i++) {
            for (int j = 0; j < input2; j++) {
                arr[i][j] = input3[pos++];
            }
        }

        int[][] upperMax = upperMax(input1, input2, arr);
        int[][] lowerMax = lowerMax(input1, input2, arr);
        int[][] leftMax = leftMax(input1, input2, arr);
        int[][] rightMax = rightMax(input1, input2, arr);

        int ans = 0;
        int count = 0;
        int globMin = Integer.MAX_VALUE;
        boolean flg = false;
        for (int i = 1; i < input1 - 1; i++) {
            for (int j = 1; j < input2 - 1; j++) {
                if (arr[i][j] != arr[i - 1][j] && arr[i][j] != arr[i + 1][j] && arr[i][j] != arr[i][j - 1] && arr[i][j] != arr[i][j + 1]) {
                    int min = upperMax[i][j] < lowerMax[i][j] ? upperMax[i][j] : lowerMax[i][j];
                    min = min < leftMax[i][j] ? min : leftMax[i][j];
                    min = min < rightMax[i][j] ? min : rightMax[i][j];

                    if (min > arr[i][j]) {
                        ans += min - arr[i][j];
                        //System.out.println(i+" "+j+" "+min+" "+arr[i][j]);
                    }
                    if (flg) {
                        ans += (globMin * count);
                    }
                    count = 0;
                    globMin = Integer.MAX_VALUE;
                    flg = false;
                } else {

                    ++count;

                    int min = upperMax[i][j] < lowerMax[i][j] ? upperMax[i][j] : lowerMax[i][j];
                    min = min < leftMax[i][j] ? min : leftMax[i][j];
                    min = min < rightMax[i][j] ? min : rightMax[i][j];

                    globMin = globMin < min ? globMin : min;
                    flg = true;
                }
            }
        }

        // printArray(input1, input2, lowerMax);
        return ans;
    }

    public static void printArray(int input1, int input2, int[][] arr) {
        for (int i = 0; i < input1; i++) {
            for (int j = 0; j < input2; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static int[][] upperMax(int input1, int input2, int[][] arr) {
        int[][] upper = new int[input1][input2];

        int pos = 0;

        for (int i = 1; i < input1; i++) {
            for (int j = 0; j < input2; j++) {
                int prv = i - 1;
                int max = 0;
                //System.out.print(i+"]["+j+"] "+arr[i][j]+" , ");
                while (prv >= 0) {
                    max = max > arr[prv][j] ? max : arr[prv][j];
                    --prv;

                }
                upper[i][j] = max;
            }
        }

        return upper;
    }

    public static int[][] lowerMax(int input1, int input2, int[][] arr) {
        int[][] lower = new int[input1][input2];

        for (int i = input1 - 1; i >= 0; i--) {
            for (int j = 0; j < input2; j++) {
                int nxt = i + 1;
                int max = 0;
                //System.out.print(i+"]["+j+"] "+arr[i][j]+" "+nxt+" , ");
                while (nxt < input1) {
                    max = max > arr[nxt][j] ? max : arr[nxt][j];
                    ++nxt;

                }
                lower[i][j] = max;
            }
        }

        return lower;
    }

    public static int[][] leftMax(int input1, int input2, int[][] arr) {
        int[][] left = new int[input1][input2];

        for (int i = 0; i < input1; i++) {
            for (int j = 1; j < input2; j++) {
                int prv = j - 1;
                int max = 0;
                //System.out.print(i+"]["+j+"] "+arr[i][j]+" , ");
                while (prv >= 0) {
                    max = max > arr[i][prv] ? max : arr[i][prv];
                    --prv;

                }
                left[i][j] = max;
            }
        }
        return left;
    }

    public static int[][] rightMax(int input1, int input2, int[][] arr) {
        int[][] right = new int[input1][input2];

        for (int i = input1 - 1; i >= 0; i--) {
            for (int j = 0; j < input2; j++) {
                int nxt = j + 1;
                int max = 0;
                //System.out.print(i+"]["+j+"] "+arr[i][j]+" "+nxt+" , ");
                while (nxt < input2) {
                    max = max > arr[i][nxt] ? max : arr[i][nxt];
                    ++nxt;

                }
                right[i][j] = max;
            }
        }

        return right;
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

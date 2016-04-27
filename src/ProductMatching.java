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
public class ProductMatching {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        String input1 = "C1(P2-5,P4-3)C2(P1-4,P2-6)C3(P1-7,P3-5,P4-6)C4(P4-10,P5-5)C5(P4-9)";
        System.out.println(matching(input1));
        out.flush();
        out.close();

    }

    public static String matching(String input1) {
        int n = 0;
        int len = input1.length();

        for (int i = 0; i < len; i++) {
            if (input1.charAt(i) == '(') {
                ++n;
            }
        }
        int[][] arr = new int[n][n];
        int[] custLike = new int[n];
        int[] prodLike = new int[n];

        for (int i = 0; i < len; i++) {
            if (input1.charAt(i) == 'C') {
                ++i;
                String tempJ = "";
                while (input1.charAt(i) != '(') {
                    tempJ += input1.charAt(i);
                    ++i;
                }
                int j = Integer.parseInt(tempJ);
                int custLikeCounter = 1;
                //System.out.print(j);++i;
                outer:
                while (i < len && input1.charAt(i) != ')') {
                    //System.out.print(input1.charAt(i));
                    if (input1.charAt(i) == 'P') {
                        String tempP = "";
                        ++i;
                        while (input1.charAt(i) != '-') {
                            tempP += input1.charAt(i);
                            ++i;
                        }
                        //System.out.print(tempP+" ,");
                        int p = Integer.parseInt(tempP);
                        String temp = "";
                        ++i;
                        while (input1.charAt(i) != ',') {
                            if (input1.charAt(i) == ')') {
                                arr[j - 1][p - 1] = Integer.parseInt(temp);
                                custLike[j - 1] = custLikeCounter;
                                ++prodLike[p - 1];
                                //System.out.print("["+j+"]["+p+"] ."+temp+" _");
                                break outer;
                            }
                            temp += input1.charAt(i);
                            ++i;
                        }
                        //System.out.print("["+j+"]["+p+"] ."+temp+" _");
                        arr[j - 1][p - 1] = Integer.parseInt(temp);
                        ++prodLike[p - 1];
                        ++custLikeCounter;
                    }
                    ++i;
                }
            }
        }
        int[][] ans = new int[n][n];
        int ansTotal = 0;
        
        int count = 1;
        
        for (int i = 0; i < n;) {
            if (custLike[i] == 1) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] != 0) {
                        prodLike[j] = 0;
                        ans[i][j] = arr[i][j];
                        ansTotal += ans[i][j];
                        changeValCust(arr, custLike, arr[i][j], n);
                        i = 0;
                        break;
                    }
                }
            } else if (prodLike[i] == 1) {
                int tempCus = findCust(arr, i, n);
                ans[tempCus][i] = arr[tempCus][i];
                ansTotal += ans[tempCus][i];

                for (int j = 0; j < n; j++) {
                    if (arr[tempCus][j] > 0) {
                        --prodLike[j];
                    }
                    arr[tempCus][j] = 0;
                }
                custLike[tempCus] = 0;
                changeValProd(arr, custLike, i, n);
                i = 0;
            } else {
                i++;
            }
        }

        //printArray(ans, n);
        //System.out.println();
        //printOneDime(custLike, n);
        //System.out.println();
        //printOneDime(prodLike, n);
        String s = ""+ansTotal;
        
        for(int i=0;i<n;i++){
            s+="(C"+(i+1)+",";
            for(int j=0;j<n;j++){
                if(ans[i][j]>0){
                    s+="P"+(j+1)+")";
                }
            }
        }
        
        return s;
    }

    static int findCust(int[][] arr, int prod, int n) {
        int i = 0;
        for (; i < n; i++) {

            if (arr[i][prod] > 0) {
                break;
            }

        }

        return i;
    }

    static void changeValCust(int[][] arr, int[] custLike, int prod, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == prod) {
                    --custLike[i];
                    arr[i][j] = 0;
                }
            }
        }
    }

    static void changeValProd(int[][] arr, int[] prodLike, int prod, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == prod) {
                    --prodLike[i];
                    arr[i][j] = 0;
                }
            }
        }
    }

    static void printArray(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void printOneDime(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
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

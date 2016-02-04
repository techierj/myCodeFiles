/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author jaimin
 */
public class PlantSurvPattern {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader)
        
        
        String[] s = in.readString().split(",");
        String[] s2 = in.readString().split(",");

        int[] arr = new int[7];

        for (int i = 0; i < 7; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int[] arr2 = new int[arr[0] * arr[1]];
        for (int i = 0; i < arr[0] * arr[1]; i++) {
            arr2[i] = Integer.parseInt(s2[i]);
        }
        out.print(survivalcells(arr, arr2));

        out.flush();
        out.close();
    }

    public static int[] survivalcells(int[] input1, int[] input2) {

        int len = input1[0] * input1[1];
        int R = input1[0];
        int C = input1[1];

        int[][] arr = new int[R][C];
        int k = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i][j] = input2[k++];
            }
        }
        
        //printArray(arr, R, C);
        
        for(int x = 0;x<input1[6];x++){
            //printArray(arr, R, C);
        int[][] temp = new int[R][C];
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int count = 0;
                if (i > 0 && j > 0 && i < R-1 && j < C-1) {

                    if (arr[i - 1][j - 1] == 1) {
                        ++count;
                    }
                    if (arr[i - 1][j] == 1) {
                        ++count;
                    }
                    if (arr[i - 1][j + 1] == 1) {
                        ++count;
                    }
                    if (arr[i][j - 1] == 1) {
                        ++count;
                    }
                    if (arr[i][j + 1] == 1) {
                        ++count;
                    }
                    if (arr[i + 1][j - 1] == 1) {
                        ++count;
                    }
                    if (arr[i + 1][j] == 1) {
                        ++count;
                    }
                    if (arr[i + 1][j + 1] == 1) {
                        ++count;
                    }

                } else if (i == 0 && j == 0) {
                    if (arr[i][j + 1] == 1) {
                        ++count;
                    }
                    if (arr[i + 1][j] == 1) {
                        ++count;
                    }
                    if (arr[i + 1][j + 1] == 1) {
                        ++count;
                    }
                } else if (i == R - 1 && j == C - 1) {
                    if (arr[i - 1][j - 1] == 1) {
                        ++count;
                    }
                    if (arr[i - 1][j] == 1) {
                        ++count;
                    }
                    if (arr[i][j - 1] == 1) {
                        ++count;
                    }
                } else if (i == 0 && j == C - 1) {
                    if (arr[i][j - 1] == 1) {
                        ++count;
                    }
                    if (arr[i + 1][j - 1] == 1) {
                        ++count;
                    }
                    if (arr[i + 1][j] == 1) {
                        ++count;
                    }
                } else if (i == R - 1 && j == 0) {
                    if (arr[i - 1][j] == 1) {
                        ++count;
                    }
                    if (arr[i - 1][j + 1] == 1) {
                        ++count;
                    }
                    if (arr[i][j + 1] == 1) {
                        ++count;
                    }
                    
                } else if (j == 0) {
                    if (arr[i - 1][j] == 1) {
                        ++count;
                    }
                    if (arr[i - 1][j + 1] == 1) {
                        ++count;
                    }
                    if (arr[i][j + 1] == 1) {
                        ++count;
                    }
                    if (arr[i + 1][j] == 1) {
                        ++count;
                    }
                    if (arr[i + 1][j + 1] == 1) {
                        ++count;
                    }
                } else if (i == 0) {
                    if (arr[i][j - 1] == 1) {
                        ++count;
                    }
                    if (arr[i][j + 1] == 1) {
                        ++count;
                    }
                    if (arr[i + 1][j - 1] == 1) {
                        ++count;
                    }
                    if (arr[i + 1][j] == 1) {
                        ++count;
                    }
                    if (arr[i + 1][j + 1] == 1) {
                        ++count;
                    }
                } else if (j == C - 1) {
                    if (arr[i - 1][j - 1] == 1) {
                        ++count;
                    }
                    if (arr[i - 1][j] == 1) {
                        ++count;
                    }
                    if (arr[i][j - 1] == 1) {
                        ++count;
                    }
                    if (arr[i + 1][j - 1] == 1) {
                        ++count;
                    }
                    if (arr[i + 1][j] == 1) {
                        ++count;
                    }
                } else {
                    if (arr[i - 1][j - 1] == 1) {
                        ++count;
                    }
                    if (arr[i - 1][j] == 1) {
                        ++count;
                    }
                    if (arr[i - 1][j + 1] == 1) {
                        ++count;
                    }
                    if (arr[i][j - 1] == 1) {
                        ++count;
                    }
                    if (arr[i][j + 1] == 1) {
                        ++count;
                    }
                }
                if (arr[i][j] == 1 && (count < input1[2] || count > input1[3])) {
                    temp[i][j] = 0;
                }else if(arr[i][j]==1){
                    temp[i][j]=1;
                }else if (arr[i][j] == 0 && count >= input1[4] && count <= input1[5]) {
                    temp[i][j] = 1;
                }else{
                    temp[i][j]=0;
                }
                
            }
            
        }
        arr = null;
        arr = temp.clone();
        }

       // printArray(arr, R, C);
        k = 0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                input2[k++]=arr[i][j];
            }
        }
        /*
        for(int i:input2){
            System.out.print(i+" ");
        }*/
        
        return input2;

    }
    
    static void printArray(int[][] arr,int R,int C){
        System.out.println("\n==============");
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("\n---------------------");
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

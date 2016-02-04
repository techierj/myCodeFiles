/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeMonk.BitManipulation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author jaimin
 */
public class MonkInTheMagicalLand {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);

        int t = in.readInt();
        boolean[] prime = new boolean[51];
        for(int i =2;i*i<51;i++){
            if(prime[i]==false){
                for(int j=i*2;j<51;j+=i){
                    prime[j]=true;
                }
            }
        }
        
        
        
        while (t-- > 0) {
            int n = in.readInt();
            int m = in.readInt();
            int k = in.readInt();

            int[] X = new int[n];
            int[] C = new int[m];
            int[] Z = new int[m];

            for (int i = 0; i < n; i++) {
                X[i] = in.readInt();
            }

            for (int i = 0; i < m; i++) {
                C[i] = in.readInt();
            }

            for (int i = 0; i < m; i++) {
                Z[i] = in.readInt();
            }
            int[] ans = new int[n];
            
            /*int[] coP = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (X[i] != -1 && X[j] != -1) {
                        if (!coPrime(X[i], X[j])) {
                            ++coP[i];
                        }
                    }
                }
            }

            */
            int[] countNum = new int[51];
            int counter=0;
            for(int i=2;i<51;i++){
                if(prime[i]==true){
                    for(int j=0;j<m;j++){
                        if(C[j]%i==0){
                            ++countNum[i];
                            
                            ++counter;
                        }
                    }
                }
            }
            System.out.println(counter);
            System.out.println("\n------\n");
            for(int i:countNum){
                System.out.print(i+" ");
            }
            System.out.println("\n------\n");
            
            for(int i=0;i<n;i++){
                //System.out.println(prime[X[i]]+" "+X[i]);
                abc:
                    for(int j=i+1;j<n;j++){
                        if(X[j]%X[i]==0){
                            X[i]=-1;
                            break abc;
                        }
                    }
                
            }
           /* System.out.println("\n------\n");
            for(int i:X){
                System.out.print(i+" ");
            }
            System.out.println("\n----\n");*/
            
            //Arrays.sort(X);
            
            for (int i = 0; i < n; i++) {
                if(X[i]!=-1)
                for (int j = 0; j < m; j++) {
                    if (Z[j] != -1) {

                        if (!coPrime(X[i], C[j])) {
                           // System.out.print((X[i] + " , " + C[j]) + " , " + Z[j] + " | ");
                            ans[i] += Z[j];
                            Z[j] = -1;
                        }

                    }
                }

            }
            Arrays.sort(ans);
            //System.out.println("..................");
            int count = 0;
            for (int i = 1; i <= k; i++) {
                //System.out.print(ans[i] + " ");
                count += ans[n - i];
            }
            System.out.println(count);

        }

        //System.out.print(sb);
    }

    static boolean coPrime(int n, int m) {
        if (((n | m) & 1) == 0) {
            return false;
        }
        while ((n & 1) == 0) {
            n >>= 1;
        }
        if (n == 1) {
            return true;
        }
        do {
            while ((m & 1) == 0) {
                m >>= 1;
            }
            if (m == 1) {
                return true;
            }

            if (n > m) {
                int t = m;
                m = n;
                n = t;
            }
            m -= n;
        } while (m != 0);
        return false;
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

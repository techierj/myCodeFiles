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
import java.util.HashMap;

/**
 *
 * @author jaimin
 */
public class HappinessScore {

    static boolean[] prime;
    static long happy;
    static HashMap<Long,Integer> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);
        prime = new boolean[500001];
        countPrime(500000);
        happy = 0;
        int n = in.readInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.readInt();
        }
        Arrays.sort(arr);
        for (int i = 1; i <= n; i++) {
            countPrime(arr, n, i);
        }
        out.println(happy);
        out.flush();
        out.close();
    }

    static void combo(int arr[], int data[], int start,
            int end, int index, int r) {
        if (index == r) {
            long num = 0;
            for (int j = 0; j < r; j++) {
                num += data[j];
                System.out.print(data[j] + " ");
            }
            System.out.println(num + " ");
            if (num < 500001) {
                int num1 = (int) num;
                if (!prime[num1] && !hm.containsKey(num)) {
                    ++happy;
                    hm.put(num, 1);
                }
            } else if (isPrime(num) && !hm.containsKey(num)) {
                ++happy;
                hm.put(num, 1);
            }
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];

            combo(arr, data, i + 1, end, index + 1, r);
            while (i<end && arr[i] == arr[i + 1]) {
                i++;
            }
        }
    }

    static boolean isPrime(long n) {
        long upTo = n >> 1;
        int count = 0;
        for (long i = 2; i < upTo; i++) {
            if (n % i == 0) {
                ++count;
                break;
            }
        }
        if (count > 0 || n == 1) {
            return false;
        }
        return true;
    }

    static void countPrime(int arr[], int n, int r) {
        int data[] = new int[r];
        combo(arr, data, 0, n - 1, 0, r);
    }
    
    public static ArrayList<ArrayList<Integer>> squareSum(int A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		for (int a = 0; a * a < A; a++) {
			for (int b = 0; b * b < A; b++) {
				if (a * a + b * b == A) {
					ArrayList<Integer> newEntry = new ArrayList<Integer>();
					newEntry.add(a);
					newEntry.add(b);
					ans.add(newEntry);
				}
			}
		}
		return ans;
	}

    public static void countPrime(int n) {

        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                //System.out.print(i+" ");
                for (int j = i * 2; j <= n; j += i) {
                    prime[j] = true;
                }
            }
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

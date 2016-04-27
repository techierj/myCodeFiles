/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author jaimin
 */
public class IoTProblem {

    static int maxLen = 0;
    static int maxLen2 = 0;

    public static int maxMediators(String[] input1, int input2) {

        return maxFar(input1, 1, input2);
    }

    public static int getCount(String[] input1, int i, int input2) {

        //System.out.println(i + " " + input2);
        if (i < input2 && !input1[i].equals("empty")) {
            //System.out.println(input1[i]+" ,");
            return (1 + (Math.max(getCount(input1, 2 * i + 1, input2), getCount(input1, 2 * i + 2, input2))));
        } else {
            return 0;
        }

    }

    public static int maxFar(String[] input1, int i, int input2) {
        if (i < input2 && !input1[i].equals("empty")) {
            int leftTree = getCount(input1, 2 * i + 1, input2);
            int rightTree = getCount(input1, 2 * i + 2, input2);

            int leftMax = maxFar(input1, 2 * i + 1, input2);
            int rightMax = maxFar(input1, 2 * i + 2, input2);

            int val = Math.max(leftTree + rightTree + 1, Math.max(leftMax, rightMax));
            //System.out.println(val+" "+i+" "+leftMax+" "+rightMax+" "+leftTree+" "+rightTree);
            //System.out.println(input1[i]);
            return val;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        String[] arr = {"empty", "D1", "D2", "D3", "D4", "D5", "D6", "empty", "C1", "empty", "C2", "C3", "D7", "D8", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "C4", "empty", "C5", "C6", "empty", "empty", "empty", "empty"};
        //String[] arr = {"empty", "D1", "C1", "C2"};
        int input2 = arr.length;
        
        
        IoTProblem obj = new IoTProblem();
        Node2 n = obj.makeTree(arr);
        System.out.println(obj.Diameter(n));

        System.out.print(maxMediators(arr, input2));

    }

    Node2 makeTree(int low, int high, String[] array) {
        if (low > high) {
            return null;
        } else {
            // Same as (low + high) / 2
            int mid = (low + high) >>> 1;
            Node2 node = new Node2(array[mid]);
            node.left = makeTree(low, (mid - 1), array);
            node.right = makeTree((mid + 1), high, array);
            return node;
        }
    }

    public Node2 makeTree(String[] array) {
        int low = 1;
        int high = array.length - 1;
        return makeTree(low, high, array);
    }

    public int getHeight(Node2 root) {
        if (root != null) {
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }
        return 0;
    }

    public int Diameter(Node2 root) {
        if (root != null) {
            // get the left and right subtree height
            int leftH = getHeight(root.left);
            int rightH = getHeight(root.right);

            // get the left diameter and right diameter recursively.
            int leftDiameter = Diameter(root.left);
            int rightDiameter = Diameter(root.right);

            // get the max leftsubtree, rightsubtree, longest path goes through
            // root.
            return getMax(leftH + rightH + 1, leftDiameter, rightDiameter);
        }
        return 0;
    }

    public int getMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
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

class Node2 {

    String data;
    Node2 left;
    Node2 right;

    void add(String data) {
        this.data = data;
    }

    Node2(String data) {
        this.data = data;
    }

    Node2() {
    }
}

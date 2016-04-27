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
public class AVLTree {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

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

class AVL {

    static Node root;

    int height(Node N) {
        if (N == null) {
            return 0;
        }
        return N.ht;
    }

    int max(int a, int b) {
        return a > b ? a : b;
    }

    Node RR(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        y.ht = max(height(y.left), height(y.right)) + 1;
        x.ht = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node LR(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.ht = max(height(x.left), height(x.right)) + 1;
        y.ht = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    Node insert(Node node, int val) {
        if (node == null) {
            Node newNode = new Node();
            newNode.val = val;
            return newNode;
        }

        if (val < node.val) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }

        node.ht = max(height(node.left), height(node.right)) + 1;

        int bal = getBalance(node);

        if (bal > 1 && val < node.left.val) {
            return RR(node);
        }
        if (bal < -1 && val > node.right.val) {
            return LR(node);
        }
        if (bal > 1 && val > node.left.val) {
            node.left = LR(node.left);
            return RR(node);
        }

        if (bal < -1 && val < node.right.val) {
            node.right = RR(node.right);
            return LR(node);
        }

        return node;
    }

    class Node {

        int val;   //Value
        int ht;      //Height
        Node left;   //Left child
        Node right;   //Right child

    }
}

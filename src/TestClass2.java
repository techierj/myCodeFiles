
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.PrintWriter;
    import java.util.ArrayList;
    import java.util.HashSet;
    import java.util.LinkedList;
    import java.util.List;
    import java.util.Queue;
    import java.util.Set;
    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

    /**
     *
     * @author jaimin
     */
    public class TestClass2 {

        public static void main(String[] args) {
            PrintWriter out = new PrintWriter(System.out);
            InputReader in = new InputReader(System.in);

            int n = in.readInt();
            int q = in.readInt();
            int k = in.readInt();

            long[] arr =new long[n+1];

            for(int i=1;i<=n;i++){
                arr[i]=in.readLong();
            }

            while(q-->0){
                int type = in.readInt();
                if(type==0){
                    arr[in.readInt()]=in.readLong();
                }else{
                    int a = in.readInt();
                    int b = in.readInt();
                    int c = in.readInt();
                    int d = in.readInt();

                    List<Long> f = new ArrayList<Long>();
                    List<Long> s = new ArrayList<Long>();

                    for(int i=a;i<=b;i++){
                        if(i<=n)
                        f.add(arr[i]);
                        if(c<=n)
                        s.add(arr[c++]);
                    }

                    int count = 0;

                    while(f.isEmpty() || s.isEmpty()){

                        if(f.get(0)==s.get(0)){
                            f.remove(0);
                            s.remove(0);
                            ++count;
                        }else if(f.get(0)<s.get(0)){
                            f.remove(0);
                        }else{
                            s.remove(0);
                        }
                    }
                    if(count>=k){
                        out.println("Propose");
                    }else{
                        out.println("Do not propose");
                    }
                }
            }

            out.flush();
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

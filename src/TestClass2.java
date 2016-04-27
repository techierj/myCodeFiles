
import com.sun.javafx.scene.control.skin.VirtualFlow;
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.PrintWriter;
    import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
    import java.util.HashSet;
import java.util.Iterator;
    import java.util.LinkedList;
    import java.util.List;
import java.util.PriorityQueue;
    import java.util.Queue;
    import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

    /**
     *
     * @author jaimin
     */
class temp{
    public void j(){
        System.out.println("JA S");
    }
}

class temp2 extends temp{
public void j(){
        System.out.println("JA");
        super.j();
    }
    
}
    public class TestClass2 implements Runnable{

        static final String ja = "ja";
        
        int a=20;
    static int b=10;
    void m1()
    {
        TestClass2 t= new TestClass2();
        System.out.println(t.b);
    }
    
        
        public static synchronized void main(String[] args) throws InterruptedException {
            final String ja = "ja";
            Thread th = new Thread(new TestClass2());
            th.start();
            System.out.println("Main1");
            th.join();
            System.out.println("Main2");
            
            new temp2().j();
            Set set = new TreeSet();
            set.add("2");
            set.add("3");
            set.add("1");
            
            Iterator it = set.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
            boolean var1 = true;
        boolean var2 = false;
        System.out.println((var2 & var2));
            
            PrintWriter out = new PrintWriter(System.out);
            InputReader in = new InputReader(System.in);

            String obj = "I LIKE coding";
        System.out.println(obj.charAt(12));
        
        int a=20, b=12;
        if((a < b) && (b++ < 25)){
            System.out.println("Hi");
        }
        System.out.println(b);
        
        int x, y;
        x = 5 >> 2;
        y = x >>> 2;
        System.out.println(y);
        
        TestClass2 t= new TestClass2();
        t.m1();
            out.flush();
            out.close();
        }

    @Override
    public void run() {
        System.out.println("JRun");
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

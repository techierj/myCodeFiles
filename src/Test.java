
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jaimin
 */
public class Test {

    class B{
        String name = "hi";
        String getData(){
            return "Hi";
        }
    }
    
    static class C{
        static String getData(){
            return "Hi2";
        }
    }
    
    public static String CeasarCypher(String input, int key) {
        int len = input.length();
        String ans="";
        
        for(int i=0;i<len;i++){
            int c = input.charAt(i);
            if(c>='a' && c<='z'){
                int dec = (c+key);
                if(dec>122){
                ans+=(char)(((c+key)%122)+96);
                }else{
                    ans+=(char)dec;
                }
            }else if(c>='A' && c<='Z'){
                int dec = (c+key);
                if(dec>90){
                ans+=(char)(((c+key)%90)+64);
                }else{
                    ans+=(char)dec;
                }
            }else{
                ans+=(char)c;
            }
        }
        return ans;
    }

    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        System.out.println(CeasarCypher("Zwddg ogjdv!", 8));
        
        Test obj2 = new Test();
        Test.B obj = obj2.new B();
        
        
        
        Test o = new Test();
        o.sampleMap();
        
        String s;
        int a;
        s = "Foolish boy.";
        a = s.indexOf("Fool");
        System.out.println(a);
        
        int i = 25;
        double d = 225.50;
        i = (int) d;
        System.out.print(i);
    }
    
    public void sampleMap(){
        TreeMap tm = new TreeMap();
        tm.put("a","Hello");
        tm.put("b","Java");
        tm.put("c","World");
        Iterator it = tm.keySet().iterator();
        while(it.hasNext()){
            System.out.print(it.next());
        }
    }

    public static int[] GetBrightnessValue(int t, String input2) {
        List<Integer> list = new ArrayList<Integer>();

        //removing brackets
        String temp = "";
        int len2 = input2.length();
        for (int i = 0; i < len2; i++) {
            if (check(input2.charAt(i))) {
                continue;
            }
            temp += input2.charAt(i);
        }
        //end of removing brc

        String[] s = temp.split(",");

        int i = 0, len = s.length;
        while (t-- > 0) {
            while (i < len) {
                int n = Integer.parseInt(s[i]);
                int[] arr = new int[n];
                int avg = 0;
                int k = n, j = 0;
                ++i;
                while (k-- > 0) {
                    arr[j] = Integer.parseInt(s[i]);
                    avg+=arr[j];
                    ++j;
                    ++i;
                }
                avg/=n;
                Arrays.sort(arr);
                int half = n >> 2;
                int f = 0, sec = 0;
                for (j = 0; j < half; j++) {
                    f += arr[j] + arr[n - 1 - j];

                    sec += arr[j + 1] + arr[n - 2 - j];
                }
                int ans = 0;
                if (n % 4 == 2) {
                    ans = (Math.max(f, sec) + arr[(half << 1) + 1] + arr[(half << 1)]);
                } else if (n % 4 == 1) {
                    ans = (Math.max(f, sec) + arr[(half << 1)]);
                } else if (n % 4 == 3) {
                    ans = (Math.max(f, sec) + arr[(half << 1) + 2] + arr[(half << 1) + 1] + arr[(half << 1)]);
                } else {
                    ans = (Math.max(f, sec));
                }
                if(ans<avg){
                    list.add(0);
                }else{
                    list.add(ans);
                }
            }
        }

        // after processing each testcase
        len = list.size();
        int[] arr = new int[len];
        for (i = 0; i < len; i++) {
            arr[i] = list.remove(0);
        }
        return arr;
    }

    static boolean check(char c) {
        if (c == '(' || c == ')' || c == '{' || c == '}') {
            return true;
        }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HackerRank.DynamicProgrammin;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
/**
 *
 * @author jaimin
 */
public class StockMaximize {
    
    static long[] arr;
    static int n;
    
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);
        
        int t = in.readInt();
        while(t-->0){
            n = in.readInt();
            arr = new long[n];
            
            for(int i=0;i<n;i++){
                arr[i]=in.readLong();
            }
            constructST();
            long ans = 0;
            for(int i=1;i<n;i++){
                long max = RMQ(i, n);
                if(arr[i-1]<max){
                    ans += max - arr[i-1];
                }
            }
            out.println(ans);
        }
        
        out.flush();
        out.close();
    }
    
    static long st[];

    static long maxVal(long x, long y) {
        return (x > y) ? x : y;
    }

    static int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    static long RMQUtil(int ss, int se, int qs, int qe, int index) {
        if (qs <= ss && qe >= se) {
            return st[index];
        }
        if (se < qs || ss > qe) {
            return Long.MIN_VALUE;
        }

        int mid = getMid(ss, se);
        return maxVal(RMQUtil(ss, mid, qs, qe, 2 * index + 1),
                RMQUtil(mid + 1, se, qs, qe, 2 * index + 2));
    }

    static long RMQ(int qs, int qe) {
        return RMQUtil(0, n - 1, qs, qe, 0);
    }

    static long constructSTUtil(int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }
        int mid = getMid(ss, se);
        st[si] = maxVal(constructSTUtil( ss, mid, si * 2 + 1),
                constructSTUtil( mid + 1, se, si * 2 + 2));
        return st[si];
    }

    static void constructST() {
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        st = new long[max_size]; // allocate memory
        constructSTUtil( 0, n - 1, 0);
    }
    
    static final class InputReader{
        private final InputStream stream;
        private final byte[] buf=new byte[1024];
        private int curChar;
        private int numChars;
        public InputReader(InputStream stream){this.stream=stream;}
        private int read()throws IOException{
            if(curChar>=numChars){
                curChar=0;
                numChars=stream.read(buf);
                if(numChars<=0)
                    return -1;
            }
            return buf[curChar++];
        }
        public final int readInt(){return (int)readLong();}
        public final long readLong(){
            int c = 0;
            try {
                c = read();
            } catch (IOException ex) {}
            while(isSpaceChar(c)){
                try {
                    c=read();
                } catch (IOException ex) {}
                }
            boolean negative=false;
            if(c=='-'){
                negative=true;
                try {
                    c=read();
                } catch (IOException ex) {}
            }
            long res=0;
            do{
                if(c<'0'||c>'9');
                res*=10;
                res+=(c-'0');
                try {
                    c=read();
                } catch (IOException ex) {}
            }while(!isSpaceChar(c));
            return negative?(-res):(res);
        }
        
        public final String readString(){
            int c = 0;
            try {
                c = read();
            } catch (IOException ex) {}
            while(isSpaceChar(c))try {
                c=read();
                } catch (IOException ex) {}
            StringBuilder res=new StringBuilder();
            do{
                res.append((char)c);
                try {
                    c=read();
                } catch (IOException ex) {}
            }while(!isSpaceChar(c));
            return res.toString();
        }
        private boolean isSpaceChar(int c){
            return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;
        }
    }
}

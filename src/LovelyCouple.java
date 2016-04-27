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
public class LovelyCouple {
    static boolean[] prime;
    static int count;
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);
        
        prime = countPrime(5000);
        
        
        int t = in.readInt();
        while(t-->0){
            count = 0;
            int a = in.readInt();
            int b = in.readInt();
            
            int i = 2;
            while(a>1 || b>1){
                boolean flg = false;
                while(a%i==0 && b%i==0){
                    flg = true;
                    a/=i;
                    b/=i;
                    
                }
                while(a%i==0){
                    a/=i;
                    flg = true;
                }
                while(b%i==0){
                    b/=i;
                    flg = true;
                }
                if(flg && !prime[i]){
                    ++count;
                }
                ++i;
            }
            if(a>0){
                if(!prime[a]){
                    ++count;
                }
            }
            if(b>0){
                if(!prime[b]){
                    ++count;
                }
            }
            if(!prime[count]){
                out.println("Yes");
            }else{
                out.println("No");
            }
        }
        
        out.flush();
        out.close();
    }
    
    public static int lcm(int a,int b){
        return (a*b)/gcd(a,b);
    }
    
    public static int gcd(int a, int b) {
        System.out.println(a+" "+b+" .");
        if (a == b) {
            return a;
        }
        if (a > b) {
            if(!prime[a-b]){
                ++count;
            }
            return gcd(a - b, b);
        }
        if(!prime[b-1]){
            ++count;
        }
        return gcd(a, b - a);
    }
    
    public static boolean[] countPrime(int n) {
        
        boolean[] arr = new boolean[n + 1];
        arr[0]=true;
        arr[1]=true;
        for (int i = 2; i * i <= n; i++) {
            if (!arr[i]) {
                //System.out.print(i+" ");
                for (int j = i * 2; j <= n; j += i) {
                    arr[j] = true;
                }
            }
        }
        return arr;
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

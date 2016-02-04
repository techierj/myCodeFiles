/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeMonk;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author jaimin
 */
public class Commutative {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        long c = 1000000007;
        int t = in.readInt();
        while(t-->0){
            long p = in.readLong();
            long i=1,j=1,count=0;
            long max = (p*(p-1))%c;
            //System.out.print(max);
            while(i<=max){
                j=1;
                while(j<=max){
                    if((exponentiation(i, j, c)-exponentiation(j, i, c))%p==0){
                        ++count;
                       // System.out.println(i+" "+j);
                    }
                    ++j;
                }
                ++i;
            }
            sb.append(count+"\n");
        }
        
        System.out.print(sb);
        
    }
    
    public static long exponentiation(long a,long b,long c){
        long ans = 1;
        while(b!=0){
            if(b%2==1){
                ans = (ans*a)%c;
            }
            a = (a*a)% c;
            b/=2;
        }
        return ans;
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

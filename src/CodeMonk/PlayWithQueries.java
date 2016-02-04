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
public class PlayWithQueries {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        
        StringBuilder sb = new StringBuilder();
        
        long n = in.readLong();
        int q = in.readInt();
        while(q-->0){
            int t = in.readInt();
            long k = in.readLong();
            if(t==1){
                sb.append(findDivisor(n, k)+"\n");
            }else if(t==2){
                sb.append(findDivisable(n, k)+"\n");
            }else{
                sb.append(findNotDivisor(n, k)+"\n");
            }
        }
        System.out.print(sb);
        
    }
    
    static long findDivisor(long n,long k){
        long count = 1;
        long i = 2;
        while(i<=n && i<=k){
            if(n%i==0 && k%i==0){
                ++count;
            }++i;
        }
        return count;
    }
    
    static long findDivisable(long n,long k){
        
        long i=n<k?n:k;
        long max=n>k?n:k;
        long count=0;
        while(i<=max){
            if(n%i==0 && i%k==0){
                ++count;
            }
            ++i;
        }
        return count;
    }
    
    static long findNotDivisor(long n,long k){
        long count=0;
        long i = 1;
        while(i<=n){
            
            if(n%i==0 && i%k!=0){
                //System.out.print(i+" ");
                ++count;
            }++i;
        }
        return count;
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

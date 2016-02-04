/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerEarth.LNMIIT_IUPCQualifierRound;

import CodeMonk.Prime_Probablity;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author jaimin
 */
public class TomAndSequence {
    public static boolean[] prime = new boolean[17485868];
    
    public static void main(String[] args) throws IOException {
        new TomAndSequence().findPrime(17485867);
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        
        long[] ans = new long[1000003];
        long prv = 1;
        int j = 1;
        for(int i=2;j<100002;i++){
            
            if(prime[i]){
                
                prv=(prv*i)%1000000007;
                ans[j++]=prv;
            }
        }
        
        int t = in.readInt();
        
        while(t-->0){
            sb.append(ans[in.readInt()]+"\n");
        }
        
        
        System.out.print(sb);
        
    }
    
    void findPrime(int n){
        
        for(int i=2;i<=n;i++){
            prime[i]=true;
        }
        
        for(int p=2;p*p<=n;p++){
            if(prime[p]==true){
                for(int i=p*2;i<=n;i+=p){
                    prime[i]=false;
                }
            }
        }
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

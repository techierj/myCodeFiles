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
public class ShortenThePath {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);
        
        String str= in.readString();
        int len = str.length();
        int n=0,e=0,s=0,w=0;
        
        for(int i=0;i<len;i++){
            switch(str.charAt(i)){
                case 'N':
                    ++n;
                    break;
                case 'S':
                    ++s;
                    break;
                case 'W':
                    ++w;
                    break;
                case 'E':
                    ++e;
                    break;
                default:
                    break;
            }
        }
        if(n>s){
            n-=s;
            s=0;
        }else{
            s-=n;
            n=0;
        }
        
        if(w>e){
            w-=e;
            e=0;
        }else{
            e-=w;
            w=0;
        }
        while(e>0){
            out.print("E");
            --e;
        }
        while(n>0){
            out.print("N");
            --n;
        }
        while(s>0){
            out.print("S");
            --s;
        }
        while(w>0){
            out.print("W");
            --w;
        }
        out.close();
        out.flush();
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

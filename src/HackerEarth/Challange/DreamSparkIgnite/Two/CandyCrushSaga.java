/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerEarth.Challange.DreamSparkIgnite.Two;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author jaimin
 */
public class CandyCrushSaga {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        int t = in.readInt()+1;
        for(int i=1;i<t;i++){
            int n = in.readInt()-1;
            int xor = in.readInt();
            int min = xor;
            int sum = min;
                //System.out.print(sum+" ");
            while(n-->0){
                int k = in.readInt();
                if(k<min){
                    min = k;
                }
                xor^=k;
                sum+=k;
               // System.out.print(xor+" ");
            }
            if(xor!=0){
                sb.append("Case #"+i+": NO\n");
            }else{
                sb.append("Case #"+i+": "+(sum-min)+"\n");
            }
        }
        System.out.print(sb);
        
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

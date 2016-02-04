/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HackerRank.Math.Comb;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
/**
 *
 * @author jaimin
 */
public class nCrTable {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);
        long[][] ncr = nCr(1001);
        int t = in.readInt();
        while(t-->0){
            int n = in.readInt();
            for(int i=0;i<=n;i++){
                out.print(ncr[n][i]+" ");
            }
            out.println();
        }
        out.flush();
        out.close();
    }
    
    static long[][] nCr(int n){
        long[][] ncr = new long[n][n];
        ncr[0][0]=1;
        for(int i=1;i<n;i++){
            ncr[i][0]=1;
            for(int j=1;j<i;j++){
                ncr[i][j]=(ncr[i-1][j-1]+ncr[i-1][j])%1000000009;
                //System.out.print(ncr[i][j]+" ");
            }
            ncr[i][i]=1;
            //System.out.println(ncr[i][i]);
        }
        return ncr;
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

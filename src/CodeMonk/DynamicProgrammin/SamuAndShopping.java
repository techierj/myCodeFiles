/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CodeMonk.DynamicProgrammin;
import java.io.IOException;
import java.io.InputStream;
/**
 *
 * @author jaimin
 */
public class SamuAndShopping {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        
        int t = in.readInt();
        while(t-->0){
            int n = in.readInt();
            int[][] arr = new int[n][3];
            for(int i=0;i<n;i++){
                arr[i][0]=in.readInt();
                arr[i][1]=in.readInt();
                arr[i][2]=in.readInt();
            }
            
            int[][] cache = new int[n][3];
            
            for(int i=0;i<3;i++){
                cache[0][i]=arr[0][i];
            }
            
            for(int i=1;i<n;i++){
                cache[i][0]=Math.min(cache[i-1][1], cache[i-1][2])+arr[i][0];
                cache[i][1]=Math.min(cache[i-1][0],cache[i-1][2])+arr[i][1];
                cache[i][2]=Math.min(cache[i-1][0],cache[i-1][1])+arr[i][2];
            }
            sb.append(Math.min(Math.min(cache[n-1][0],cache[n-1][1]),cache[n-1][2])+"\n");
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

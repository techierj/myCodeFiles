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
public class SuperNaturalSquad2 {
    static long[][] arr;
    static int k;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        
        int t = in.readInt();
        while(t-->0){
            
            int n = in.readInt();
            k = in.readInt();
            arr = new long[n+1][n+1];
            for(int i=0;i<=n;i++){
                for(int j=0;j<=n;j++){
                    arr[i][j]=-1;
                }
            }
            sb.append(count(n,n)+"\n");
        }
        
        System.out.print(sb);
        
    }
    
    public static long count(int n,int m){
        if(n==0)return 1;
        if(m==0)return 0;
        if(n<0 || n<k || m<k) return 0;
        if(arr[n][m]==-1){
            arr[n][m]=count(n,m-1)+count(n-m,m);
        }
        return arr[n][m];
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

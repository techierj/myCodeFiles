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
public class VibhuAndHisMathematics {
    long[] arr;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        
        int t = in.readInt();
        VibhuAndHisMathematics obj = new VibhuAndHisMathematics();
        obj.count(1000006);
        while(t-->0){
            
            int n = in.readInt();
            
            sb.append(obj.arr[n]);
        }
        
        System.out.print(sb);
        
    }
    
     long count(int n){
        
         arr = new long[n+1];
         arr[0]=1;
         arr[1]=1;
         ++n;
         for(int i=2;i<n;i++){
             arr[i]=(arr[i-1]+arr[i-2]*(i-1))%1000000007;
         }
        //System.out.print(arr[n]+" ");
        return arr[n-1];
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

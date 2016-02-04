/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HackerRank.DynamicProgrammin;
import java.io.IOException;
import java.io.InputStream;
/**
 *
 * @author jaimin
 */
public class TheMaximumSubarray {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        
        int t = in.readInt();
        while(t-->0){
            int n = in.readInt();
            int min = 0;
            long all=0;
            int[] arr= new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.readInt();
                if(arr[i]<0){
                    min++;
                }else{
                    all+=arr[i];
                }
            }
            if(min==n){
                int minimum = Integer.MIN_VALUE;
                int pos = 0;
                for(int i=0;i<n;i++){
                    if(arr[i]>minimum){
                        minimum=arr[i];
                    }
                }
                sb.append(minimum+" "+minimum+"\n");
            }else{
                long maxSum = 0;
                int startPos = 0;
                int endPos = 0;
                int curPos = 0;
                long curSum = 0;
                long val = 0;
                for(int i=0;i<n;i++){
                    val = curSum + arr[i];
                    if(val>0){
                        curSum = val;
                    }else{
                        curSum = 0;
                    }
                    if(maxSum<curSum){
                        maxSum = curSum;
                    }
                }
                sb.append(maxSum+" "+all+"\n");
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

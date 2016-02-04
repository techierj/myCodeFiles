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
public class MinionsSequence {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);
        int fib[] = fib(102);
        int t = in.readInt();
        while(t-->0){
            int n = in.readInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = in.readInt();
            }
            int k = in.readInt();
            int len = n-k;
            int ans = 0;
            int[] dp = new int[n];
            int f = arr[n-k];
            int count = 0;
            for(int i=n-k+1;i<n;i++){
                if(f<arr[i]){
                    ++count;
                }
            }
            if(count==k-1){
                dp[n-k]=1;
            }else{
                dp[n-k]=0;
            }
            for(int i=n-k-1;i>=0;i--){
                if(arr[i]>=arr[i+1]){
                    dp[i]=dp[i+1]+1;
                }else{
                    if(dp[i+1]>0)
                    dp[i]=(int) (Math.pow(2, dp[i+1]+1))+1;
                }
                out.println(dp[i]);
            }
            
            
          /*  for(int i=0;i<=len;i++){
                int count = 1;
                for(int j=i+1;j<n;j++){
                    if(arr[j]>=arr[i]){
                        ++count;
                        out.print(arr[j]+" ");
                    }
                    
                }
                if(count>=k){
                    ans+=Math.pow(2, count-k+1)-1;
                }
                
                out.println("---");
                out.println(count+"--");
               // ans+=Math.pow(2, count);
                out.println(ans+" .");
            }
            out.println(ans);
        }
        */
            for(int i:dp){
                out.print(i+" ");
            }
            out.println();
            out.print(dp[0]);
        }
         
        out.flush();
        out.close();
    }
    
    static int[] fib(int n){
        int[] arr = new int[n];
        arr[0]=1;
        arr[1]=1;
        for(int i = 2;i<n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr;
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

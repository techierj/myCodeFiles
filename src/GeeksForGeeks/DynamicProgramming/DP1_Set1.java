/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GeeksForGeeks.DynamicProgramming;
import java.io.IOException;
import java.io.InputStream;
/**
 *
 * @author jaimin
 */
public class DP1_Set1 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        
        DP1_Set1 obj = new DP1_Set1();
        int[] arr = obj.initialize(41);
        
        System.out.print(obj.fibT(arr, 40));
        
        System.out.print(sb);
        
    }
    
    int fibT(int[]arr,int n){
        if(arr[n]==-1){
            if(n<=1){
                arr[n]=n;
            }else{
                arr[n]=fibT(arr, n-1)+fibT(arr, n-2);
            }
        }
        return arr[n];
    }
    
    int[] initialize(int n){
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=-1;
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

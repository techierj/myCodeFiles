/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HeapsAndPriorityQueues;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 *
 * @author jaimin
 */
public class MonkAndSomeQueries {
    static int len;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        len = 1;
        int t = in.readInt();
        Queue<Integer> max = new PriorityQueue<Integer>(100000,Collections.reverseOrder());
        Queue<Integer> min = new PriorityQueue<Integer>();
        int len=0;
        while(t-->0){
            int p = in.readInt();
            if(p==1){
                int val = in.readInt();
                max.add(val);
                min.add(val);
                ++len;
            }else if(p==2){
                int val = in.readInt();
                
                if(max.remove(val)){
                    min.remove(val);
                    --len;
                }else{
                    sb.append("-1\n");
                }
            }else if(len==0){
                sb.append("-1\n");
            }else if(p==3){
                    sb.append(max.peek()+"\n");
            }else{
                    sb.append(min.peek()+"\n");
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

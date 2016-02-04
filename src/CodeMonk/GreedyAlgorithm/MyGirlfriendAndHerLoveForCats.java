/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CodeMonk.GreedyAlgorithm;
import java.io.IOException;
import java.io.InputStream;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 *
 * @author jaimin
 */
public class MyGirlfriendAndHerLoveForCats {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        int n = in.readInt();
        
        Queue<Long> catS = new PriorityQueue<Long>();
        Queue<Long> foodS = new PriorityQueue<Long>();
        
        
        for(int i=0;i<n;i++){
            catS.add(in.readLong());
        }
        
        for(int i=0;i<n;i++){
            foodS.add(in.readLong());
        }
        
        long sum = 0;
        for(int i=0;i<n;i++){
            sum=(long)sum+(catS.poll()*foodS.poll());
        }
        
        System.out.print(sum);
        
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
        public final String readLine(){
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
            }while(c!='\n');
            return res.toString();
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

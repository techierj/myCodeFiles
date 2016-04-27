/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeMonk.Hashing;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jaimin
 */
public class MonkAndTasks {
    static List<Long>[] total_bits;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        
        int t = in.readInt();
        
        while(t-->0){
            total_bits = new ArrayList[63];
            
            for(int i=0;i<63;i++){
                total_bits[i] = new ArrayList<Long>();
            }
            int n = in.readInt();
            while(n-->0){
                countOnes(in.readLong());
            }
            
            for(int i=0;i<63;i++){
                int size = total_bits[i].size();
                
                if(size>0){
                    
                    //Collections.sort(total_bits[i]);
                    int j = 0;
                    while(size-->0){
                        sb.append(total_bits[i].get(j++)+" ");
                    }
                }
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
        
        
    }
    
    static int matching(String out1,String out2){
        String[] line = out1.split(" ");
        String[] line2 = out2.split(" ");
        int count = 0;
        for(int i = 0;i<line.length;i++){
            if(!line[i].equals(line2[i])){
                ++count;
            }
        }
        return count;
    }
    static void countOnes(long num){
        int count = 0;
        long num2 = num;
        while(num>0){
            num = num & (num-1);
            ++count;
        }
        total_bits[count].add(num2);
        System.out.println(total_bits[count].get(0)+" "+count);
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

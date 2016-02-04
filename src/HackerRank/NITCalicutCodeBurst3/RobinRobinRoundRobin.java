/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerRank.NITCalicutCodeBurst3;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author jaimin
 */
public class RobinRobinRoundRobin {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        int n = in.readInt();
        long timeLim = in.readLong();
        long arr[] = new long[n];
        long start[] = new long[n];
        long c[] = new long[n];
        start[0] = 0;
        arr[0] = in.readLong();
        long div = arr[0]/timeLim;
        if(div*timeLim==arr[0])c[0]=div;
        else c[0]=div+1;
        for(int i=1;i<n;i++){
            arr[i] = in.readLong();
            
            div = arr[i]/timeLim;
            if(div%timeLim==0)c[i]=div;
            else c[i]=div+1;
            
            if(arr[i-1]<timeLim){
                start[i] = start[i-1]+arr[i-1]; 
            }else{
                start[i] = start[i-1]+timeLim;
            }
        }
        
        
        int q = in.readInt();
        while(q-->0){
            int count = 1;
            int ty = in.readInt();
            if(ty==1){
                sb.append(start[in.readInt()-1]+"\n");
            }else{
                int num =in.readInt()-1;
                for(int i=0;i<num;i++){
                    if(arr[i]<=(c[num]*timeLim)){
                        count++;
                    }
                }
                for(int i=num+1;i<n;i++){
                    if(arr[i]<=(c[num]-1)*timeLim){
                        count++;
                    }
                }
                sb.append(count+"\n");
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

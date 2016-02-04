/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HackerRank.BitManipulation;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
/**
 *
 * @author jaimin
 */
public class Cipher {
    static PrintWriter out;
    public static void main(String[] args) throws IOException {
        out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);
        
        int n = in.readInt();
        int k = in.readInt();
        String ans = "";
        String s = in.readString();
        int len = s.length();
        int[]last = new int[n+k];
        int min = n-k;
        int temp = 0;
        for(int i=0;i<k;i++){
            last[i]=Character.getNumericValue(s.charAt(i));
            temp = temp^last[i];
            out.print(temp);
            temp=last[i];
        }
        for(int i=k;i<n;i++){
            int val = Character.getNumericValue(s.charAt(i));
            temp = temp^last[i-k];
            last[i]=temp^val;
            out.print(last[i]);
            temp = temp^last[i];
        }
        out.println(1&2&3&5&6&7);
        out.println(ans);
        out.flush();
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

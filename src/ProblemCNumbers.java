/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
/**
 *
 * @author jaimin
 */
public class ProblemCNumbers {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out,true);
        InputReader in = new InputReader(System.in);
        
        int t = in.readInt();
        for(int k=1;k<=t;k++){
            BigDecimal ans = new BigDecimal("1");
            int n = in.readInt();
            BigDecimal num = new BigDecimal("5.236068");
            for(int i=1;i<=n;i++){
                ans = ans.multiply(num);
                out.println(i+" "+ans);
            }
           
            String ans2 = ans.toString();
            String s[] = ans2.split("\\.");
            if(s[0].length()>2){
                out.println(s[0].substring(s[0].length()-3, s[0].length()));
            }else if(s[0].length()==2){
                out.println("0"+s[0].substring(s[0].length()-2, s[0].length()));
            }else if(s[0].length()==1){
                out.println("00"+s[0].substring(s[0].length()-1, s[0].length()));
            }else{
                out.println("000");
            }
        }
        
        out.close();
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

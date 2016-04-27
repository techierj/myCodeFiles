/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author jaimin
 */
public class Spriral {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out,true);
        InputReader in = new InputReader(System.in);
        
        Integer A[]={1, 2};
        List<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        B.add(0, new ArrayList<Integer>(Arrays.asList(A)));
        spiralOrder(B);
        out.close();
    }
    
    static public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 int firstEnd = a.size();
                 int secondEnd = a.get(0).size();
                 int firstStart = 0;
                 int secondStart = 0;
                 int i=0;
                 
                 
                 while(firstStart<firstEnd && secondStart<secondEnd){
                     for(i=secondStart;i<secondEnd;i++){
                         System.out.print(a.get(firstStart).get(i)+" ");
                     }
                     firstStart++;
                     for(i=firstStart;i<firstEnd;i++){
                         System.out.print(a.get(i).get(secondEnd-1));
                     }
                     
                     secondEnd--;
                     
                     if(firstStart<firstEnd){
                         for(i=secondEnd-1;i>=firstStart;i--){
                             System.out.print(a.get(firstEnd-1).get(i));
                         }
                         firstEnd--;
                     }
                     if(secondStart<secondEnd){
                         for(i=firstEnd-1;i>=firstStart;i--){
                             System.out.print(a.get(i).get(secondStart));
                         }
                         secondStart++;
                     }
                 }
                 
		 return result;
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

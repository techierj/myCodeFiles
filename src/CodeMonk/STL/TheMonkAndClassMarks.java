/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeMonk.STL;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jaimin
 */
public class TheMonkAndClassMarks {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        int n = in.readInt();
        
        List<List<String>> list= new ArrayList<List<String>>(101);
        for(int i=0;i<101;i++){
            list.add(new ArrayList<String>());
        }
        while(n-->0){
            String name = in.readString();
            int mark = in.readInt();
            
            List<String> temp = list.get(mark);
            if(temp.isEmpty() || temp==null){
                List<String> temp2 = new ArrayList<String>();
                temp2.add(name);
                list.set(mark, temp2);
            }else{
                temp.add(name);
                Collections.sort(temp);
                list.set(mark,temp);
            }
        }
        for(int i=100;i>0;i--){
                if(!(list.get(i).isEmpty())){
                    for(String str:list.get(i)){
                        sb.append(str+" "+i+"\n");
                    }
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

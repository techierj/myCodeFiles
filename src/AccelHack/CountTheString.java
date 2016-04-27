/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AccelHack;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 *
 * @author jaimin
 */
public class CountTheString {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);
        
        int t = in.readInt();
        while(t-->0){
            int n = in.readInt();
            int k = in.readInt();
            String s = in.readString();
            HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
            for(int i=0;i<n;i++){
                if(hm.containsKey(s.charAt(i))){
                    hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
                }else{
                    hm.put(s.charAt(i),1);
                }
            }
            List<Node> list = new ArrayList<Node>();
            Iterator it = hm.entrySet().iterator();
            while(it.hasNext()){
                 Map.Entry temp = (Map.Entry)it.next();
                 int val = (int)temp.getValue();
                 if(val>k){
                     list.add(new Node(val, (char)temp.getKey()));
                 }
            }
            boolean flg = false;
            if(list.size()==0){
                flg = true;
            }
            Collections.sort(list,new Comparator<Node>() {

                @Override
                public int compare(Node o1, Node o2) {
                    if(o2.val==o1.val){
                        return o1.c-o2.c;
                    }
                    return o2.val-o1.val;
                }
            });
            //out.print(list.size()+" "+hm.size());
            
            while(!list.isEmpty()){
                out.print(list.remove(0).c);
            }
            if(flg){
                out.print("NONE");
            }
            out.println();
        }
        
        out.flush();
        out.close();
        
    }
    
    static class Node{
        int val;
        char c;
        
        Node(int val,char c){
            this.val = val;
            this.c = c;
        }
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

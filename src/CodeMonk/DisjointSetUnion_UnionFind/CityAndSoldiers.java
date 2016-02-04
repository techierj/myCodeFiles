package CodeMonk.DisjointSetUnion_UnionFind;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author jaimin
 */
public class CityAndSoldiers {
    static int[] arr ;
    
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        
        int n = in.readInt();
        int q = in.readInt();
        
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i;
        }
        
        while(q-->0){
            int x = in.readInt();
            
            if(x==1){
                union(in.readInt()-1, in.readInt()-1);
            }else if(x==2){
                int a = in.readInt()-1;
                arr[root(a)]=a;
                arr[a] = a;
                
            }else{
                sb.append(root(in.readInt()-1)+1+"\n");
            }
        }
        
        
        System.out.print(sb);
        
    }
    
    static void union(int a,int b){
        int i = root(a);
        int j = root(b);
        
        if(i==j){
            return;
        }
        arr[i]=j;
    }
    
    static int root(int p){
        while(p!=arr[p]){
            arr[p]=arr[arr[p]];
            p = arr[p];
        }
        return p;
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

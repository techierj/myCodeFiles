package CodeMonk.DisjointSetUnion_UnionFind;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 *
 * @author jaimin
 */
public class CityAndCampers {
    static int[] arr ;
    static int[] size ;
    static int max,min,prev;
    
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        int n = in.readInt();
        int q = in.readInt();
        max = 0;
        min = Integer.MAX_VALUE;
        prev = -1;
        arr =new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i;
            size[i]=1;
        }
        
        if(q>1){
            while(q-->0){
                union(in.readInt()-1, in.readInt()-1);
                //System.out.println(max+" "+min);
                if(max<n){
                    sb.append(max-min+1+"\n");
                }else{
                    sb.append("0\n");
                }
                
            }
        }else{
            sb.append("0\n");
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
        size[j]+=size[i];
        
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

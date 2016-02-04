/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeMonk.GraphTheory.I;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaimin
 */
public class MonksBirthdayTreat {
    static int count;
    public static void main(String[] args) throws IOException {
        count = 0;
        InputReader in = new InputReader(System.in);
        int n = in.readInt();
        int d = in.readInt();
        
        MonksBirthdayTreat obj = new MonksBirthdayTreat();
        MonksBirthdayTreat.Graph g = obj.new Graph(n);
        
        while(d-->0){
            int a = in.readInt();
            int b = in.readInt();
            g.addEdge(--a,--b);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            g.marked = new boolean[n];
            count = 0;
            if(!g.marked[i]){
                g.dfs(i);
                min = Math.min(count, min);
            }
        }
        
        System.out.print(min);
        
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
    
    class Graph{
        List<Integer>[] adj;
        boolean marked[];
        
        Graph(int v){
            marked = new boolean[v];
            adj =new ArrayList[v];
            for(int i=0;i<v;i++){
                adj[i] = new ArrayList<Integer>();
            }
        }
        
        void addEdge(int v1,int v2){
            adj[v1].add(v2);
        }
        
        void dfs(int i){
            marked[i]=true;
            ++count;
            for(int j=0;j<adj[i].size();j++){
                int nxt = adj[i].get(j);
                if(!marked[nxt]){
                    dfs(nxt);
                }
            }
        }
    }
}



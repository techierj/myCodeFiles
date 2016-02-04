/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeMonk.GraphTheory.I;

import static CodeMonk.GraphTheory.I.KingdomOfMonkeys.count;
import static CodeMonk.GraphTheory.I.KingdomOfMonkeys.visited;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaimin
 */
public class KingdomOfMonkeys {
    static long count;
    static long[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        
        int t = in.readInt();
        while(t-->0){
            
            int n = in.readInt();
            int m = in.readInt();
            
            KingdomOfMonkeys obj = new KingdomOfMonkeys();
            KingdomOfMonkeys.Graph g = obj.new Graph(n);
            
            arr = new long[n];
            visited = new boolean[n];
            
            
            while(m-->0){
                int x = in.readInt();
                int y = in.readInt();
                
                g.addEdge(--x,--y);
            }
            
            for(int i=0;i<n;i++){
                arr[i] = in.readLong();
            }
            
            sb.append(g.getAns(arr,n)+"\n");
            g.graph = null;
            arr = null;
            
        }
        System.out.print(sb);
        
    }
    
    static final class InputReader{
        private final InputStream stream;
        private final byte[] buf=new byte[1024];
        private int curChar;
        private int numChars;
        public InputReader(InputStream stream){this.stream=stream;}
        private int read(){
            if(curChar>=numChars){
                curChar=0;
                try {
                    numChars=stream.read(buf);
                } catch (IOException ex) {}
                if(numChars<=0)
                    return -1;
            }
            return buf[curChar++];
        }
        public final int readInt(){return (int)readLong();}
        public final long readLong(){
            int c = 0;
            c = read();
            while(isSpaceChar(c)){
                c=read();
                }
            boolean negative=false;
            if(c=='-'){
                negative=true;
                c=read();
            }
            long res=0;
            do{
                if(c<'0'||c>'9');
                res*=10;
                res+=(c-'0');
                c=read();
            }while(!isSpaceChar(c));
            return negative?(-res):(res);
        }
        
        public final String readString(){
            int c = 0;
            c = read();
            while(isSpaceChar(c)){
                c=read();
                }
            StringBuilder res=new StringBuilder();
            do{
                res.append((char)c);
                c=read();
            }while(!isSpaceChar(c));
            return res.toString();
        }
        private boolean isSpaceChar(int c){
            return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;
        }
    }
    
    class Graph{
        
        List<Integer>[] graph;
        boolean visited[];
        
        Graph(int v){
            visited = new boolean[v];
            graph = (ArrayList<Integer>[]) new ArrayList[v];
            for(int i=0;i<v;i++){
                graph[i] = new ArrayList<Integer>();
            }
        }
        
        void addEdge(int x,int y){
            graph[x].add(y);
            graph[y].add(x);
        }
        
        void dfs(int i,long count,long[] arr){
            visited[i]=true;
            count +=arr[i];
            for(int j=0;j<graph[i].size();j++){
                int nxt = graph[i].get(j);
                if(!visited[nxt]){
                    dfs(nxt,count,arr);
                }
            }
        }
        
        long getAns(long[] arr,int n){
            long max = 0;
            for(int i=0;i<n;i++){
                count = 0;
                if(!visited[i]){
                     dfs(i,count,arr);
                     max = Math.max(count,max);
                     }
            }
            return max;
        }
        
        
    }
}



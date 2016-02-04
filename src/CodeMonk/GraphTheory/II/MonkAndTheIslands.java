/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CodeMonk.GraphTheory.II;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 *
 * @author jaimin
 */
public class MonkAndTheIslands {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);
        
        int t = in.readInt();
        while(t-->0){
            int n = in.readInt();
            int m = in.readInt();
            
            Graph g = new Graph(n);
            
            while(m-->0){
                g.addEdge(in.readInt()-1,in.readInt()-1);
            }
            out.println(g.bfs(n));
        }
        
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
class Graph{
        List<Integer>[] graph;
        boolean[] visited;
        int[] dis;
        Graph(int n){
            graph = new ArrayList[n];
            visited = new boolean[n];
            dis = new int[n];
            for(int i=0;i<n;i++){
                graph[i] = new ArrayList<Integer>();
            }
        }
        
        void addEdge(int u,int v){
            graph[u].add(v);
            graph[v].add(u);
        }
        
        int bfs(int n){
            Queue<Integer> q = new LinkedList<Integer>();
            
            while(!graph[0].isEmpty()){
                int val = graph[0].remove(0);
                q.add(val);
                visited[val]=true;
                dis[val]=1;
            }
            
            while(!q.isEmpty()){
                int i = q.poll();
                int temp = dis[i]+1;
                while(!graph[i].isEmpty()){
                    int j = graph[i].remove(0);
                    if(!visited[j]){
                        dis[j]=temp;
                        q.add(j);
                        visited[j]=true;
                    }
                }
            }
            return dis[n-1];
        }
    }
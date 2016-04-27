/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CodeMonk.MinimumSpanningTree;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jaimin
 */
public class CheckIt {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        
        int t = in.readInt();
        while(t-->0){
            int n = in.readInt();
            int m = in.readInt();
            CheckIt ds = new CheckIt();
            Graph g = new Graph(40001);
            int j = n;
            while(m-->0){
                int a = in.readInt()-1;
                int b = in.readInt()-1;
                g.add(a,b);
                //g.add(b,a);
            }
            boolean flg = false;
            g.dfs(0);
            while(n-->1){
                int i = in.readInt()-1;
                System.out.print(g.visited[i]+":"+i+" ");
                if(g.visited[i]){
                    flg = true;
                    if(n!=1)
                    in.readLine();
                    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    //br.readLine();
                    break;
                }
            }
            /*System.out.println();
            for(int i=0;i<j;i++){
                System.out.print(g.visited[i]+" ");
            }*/
            //System.out.println();
            if(flg){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
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
        public final String readLine(){
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
            }while(c!='\n');
            return res.toString();
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
    static int count;
    List<Integer>[] graph;
    boolean[] visited;
    Graph(int n){
        count = 0;
        visited = new boolean[n];
        graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<Integer>();
        }
    }
    
    void add(int a,int b){
        graph[a].add(b);
    }
    
    void dfs(int a){
        int len = graph[a].size();
        int num=0;
        for(int i=0;i<len;i++)
            num = graph[a].remove(0);
        //System.out.print(num);
            if(!visited[num]){
                visited[num]=true;
            }
        }
    }
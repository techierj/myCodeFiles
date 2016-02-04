/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HackerRank.GraphTheory;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 *
 * @author jaimin
 */
public class DijkstraShortestReach2 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);
        
        int t = in.readInt();
        while(t-->0){
            int n = in.readInt();
            int m = in.readInt();
            Graph2 g = new Graph2(n, m);
            
            for(int i=0;i<m;i++){
                g.add(in.readInt()-1, in.readInt()-1, in.readInt());
            }
            int source = in.readInt()-1;
            g.addTopq(source);
            g.dijkstra(m);
            for(int i=0;i<n;i++){
                if(i==source){
                    continue;
                }else if(g.dis[i]==Integer.MAX_VALUE){
                    out.print("-1 ");
                }else{
                    out.print(g.dis[i]+" ");
                }
            }
            out.println();
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
class Graph2 {

    List<Node>[] graph;
    boolean[] visited;
    int[] dis;
    Queue<Node> pq;

    Graph2(int n, int v) {
        pq = new PriorityQueue<Node>(v, new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });
        graph = (ArrayList<Node>[]) new ArrayList[n];
        visited = new boolean[n];
        dis = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Node>();
            dis[i] = Integer.MAX_VALUE;
        }
    }

    void add(int x, int y, int weight) {
        Node temp = new Node(y, weight);
        graph[x].add(temp);
        temp = new Node(x, weight);
        graph[y].add(temp);

    }

    void dijkstra(int v) {

        while (!pq.isEmpty()) {
            Node temp2 = pq.poll();
            //System.out.print(temp2.x + "..\n");

            while (!graph[temp2.x].isEmpty()) {
                Node t = graph[temp2.x].remove(0);
              //  System.out.print(t.weight+" "+t.x+" : ");
                
                if (!visited[temp2.x]&& dis[t.x] > dis[temp2.x]+t.weight) {
                    dis[t.x] = dis[temp2.x]+t.weight;
                    pq.add(new Node(t.x,dis[temp2.x]+t.weight));
                }

            }

            visited[temp2.x] = true;
        }

    }

    void addTopq(int n){
        Node temp = new Node(n, 0);
        pq.add(temp);
        dis[n]=0;
    }
    class Node {

        int x;
        int weight;

        Node(int v, int dis) {
            x = v;
            weight = dis;
        }
    }
}
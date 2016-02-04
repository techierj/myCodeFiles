/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class MetroTrainMinimumDistance {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

//        String[] lines = new String[4];
//        for (int i = 0; i < 3; i++) {
//            lines[0] = in.readString();
//        }
//        
//        String nodes = in.readString();
//        
        String[] input1 = {"1-2-30#2-3-25#3-4-30#4-5-45#5-6-30#6-7-15#7-8-60#8-9-40", "10-11-45#11-4-60#12-13-45#13-14-30#14-15-35", "1-3-40#3-4-25#4-16-30#16-17-15#17-18-20#18-19-30#19-20-25", "21-12-30#12-17-180#17-22-45"};
        String input2 = "12#18";
        quickestroute(input1, input2);
        out.flush();
        out.close();
    }

    public static String[] quickestroute(String[] input1, String input2) {
        int n = 0;
        int len = input1.length;
        for (int i = 0; i < len; i++) {
            n += input1[i].length();
        }
        Graph g = new Graph(n, n);
        for (int i = 0; i < len; i++) {

            String[] temp = input1[i].split("#");
            int len2 = temp.length;
            for (int j = 0; j < len2; j++) {
                String[] temp2 = temp[j].split("-");
                g.add(Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1]), Integer.parseInt(temp2[2]), (char) ('0' + i));
            }
        }
        String[] outputLine = input2.split("#");
        int Source = Integer.parseInt(outputLine[0]);
        g.setDestination(Integer.parseInt(outputLine[1]));
        g.addTopq(Source, '1');
        g.dijkstra(Source);
//        for(int i=0;i<n;i++){
//                if(i==Source){
//                    continue;
//                }else if(g.dis[i]==Integer.MAX_VALUE){
//                    System.out.print("-1 ");
//                }else{
//                    System.out.print(g.dis[i]+" ");
//                }
//            }
        /*System.out.println(g.dis[Integer.parseInt(outputLine[1])]);
        for (int i = 0; i < 4; i++) {
            System.out.println(g.lineOutput[i].toString());
        }*/
        return g.lineOutput;
    }

    static final class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() throws IOException {
            if (curChar >= numChars) {
                curChar = 0;
                numChars = stream.read(buf);
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public final int readInt() {
            return (int) readLong();
        }

        public final long readLong() {
            int c = 0;
            try {
                c = read();
            } catch (IOException ex) {
            }
            while (isSpaceChar(c)) {
                try {
                    c = read();
                } catch (IOException ex) {
                }
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                try {
                    c = read();
                } catch (IOException ex) {
                }
            }
            long res = 0;
            do {
                if (c < '0' || c > '9');
                res *= 10;
                res += (c - '0');
                try {
                    c = read();
                } catch (IOException ex) {
                }
            } while (!isSpaceChar(c));
            return negative ? (-res) : (res);
        }

        public final String readString() {
            int c = 0;
            try {
                c = read();
            } catch (IOException ex) {
            }
            while (isSpaceChar(c)) {
                try {
                    c = read();
                } catch (IOException ex) {
                }
            }
            StringBuilder res = new StringBuilder();
            do {
                res.append((char) c);
                try {
                    c = read();
                } catch (IOException ex) {
                }
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}

class Graph {

    List<Node>[] graph;
    boolean[] visited;
    int[] dis;
    int des;
    Queue<Node> pq;
    String[] lineOutput = {"NC", "NC", "NC", "NC"};
//    String[] lineBlack = {"NC","NC","NC","NC"};
//    String lineBlue = "NC";
//    String lineRed = "NC";
//    String lineGreen = "NC";

    void setDestination(int des) {
        this.des = des;
    }

    Graph(int n, int v) {
        pq = new PriorityQueue<Node>(v, new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                if (o1.lineCode == o2.lineCode) {
                    return o1.weight - o2.weight;
                } else {
                    return o1.weight - (o2.weight + 30);
                }
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

    void add(int x, int y, int weight, char lineCode) {
        Node temp = new Node(y, weight, lineCode);
        graph[x].add(temp);
        temp = new Node(x, weight, lineCode);
        graph[y].add(temp);

    }

    void dijkstra(int v) {

        while (!pq.isEmpty()) {
            Node temp2 = pq.poll();
            //System.out.print(temp2.x + "..\n");
            outer:
            while (!graph[temp2.x].isEmpty()) {
                Node t = graph[temp2.x].remove(0);
                //  System.out.print(t.weight+" "+t.x+" : ");

                if (!visited[temp2.x] && dis[t.x] > dis[temp2.x] + t.weight) {
                    dis[t.x] = dis[temp2.x] + t.weight;
                    pq.add(new Node(t.x, dis[temp2.x] + t.weight, t.lineCode));
                    if (temp2.lineCode == '0') {
                        if (lineOutput[0] == "NC") {
                            lineOutput[0] = temp2.x + "-" + t.x + "-" + t.weight;
                        } else {
                            lineOutput[0] += "#" + temp2.x + "-" + t.x + "-" + t.weight;
                        }
                    } else if (temp2.lineCode == '1') {
                        if (lineOutput[1] == "NC") {
                            lineOutput[1] = temp2.x + "-" + t.x + "-" + t.weight;
                        } else {
                            lineOutput[1] += "#" + temp2.x + "-" + t.x + "-" + t.weight;
                        }
                    } else if (temp2.lineCode == '2') {
                        if (lineOutput[2] == "NC") {
                            lineOutput[2] = temp2.x + "-" + t.x + "-" + t.weight;
                        } else {
                            lineOutput[2] += "#" + temp2.x + "-" + t.x + "-" + t.weight;
                        }
                    } else if (temp2.lineCode == '3') {
                        if (lineOutput[3] == "NC") {
                            lineOutput[3] = temp2.x + "-" + t.x + "-" + t.weight;
                        } else {
                            lineOutput[3] += "#" + temp2.x + "-" + t.x + "-" + t.weight;
                        }
                    }
                    if (temp2.x == des) {
                        break outer;
                    }
                    //System.out.println(des+"// "+t.x);
                }

            }

            visited[temp2.x] = true;

        }

    }

    void addTopq(int n, char lineCode) {
        Node temp = new Node(n, 0, lineCode);
        pq.add(temp);
        dis[n] = 0;
    }

    class Node {

        int x;
        int weight;
        char lineCode;

        Node(int v, int dis, char lineCode) {
            x = v;
            weight = dis;
            this.lineCode = lineCode;
        }
    }
}

//{1-2-30#2-3-25#3-4-30#4-5-45#5-6-30#6-7-15#7-8-60#8-9-40,10-11-45#11-4-60#12-13-45#13-14-30#14-15-35,1-3-40#3-4-25#4-16-30#16-17-15#17-18-20#18-19-30#19-20-25,21-12-30#12-17-180#17-22-45
//12#18

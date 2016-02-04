/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HackerRank.GraphTheory;
import com.sun.org.apache.bcel.internal.generic.F2D;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
/**
 *
 * @author jaimin
 */
public class Floyd_CityOfBlindingLights {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);
        
        Floyd_CityOfBlindingLights f = new Floyd_CityOfBlindingLights();
        f.start();
        
        String s1 = "Hello";
        StringBuffer sb = new StringBuffer(s1);
        sb.reverse();
        s1.concat(sb.toString());
        System.out.println(s1 + sb + s1.length() + sb.length());
        
        int n = in.readInt();
        int m = in.readInt();
        
        int dis[][] = new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j)
                dis[i][j]=Integer.MAX_VALUE;
                
            }
            
        }
        
        
        for(int i=0;i<m;i++){
            int u = in.readInt()-1;
            int v = in.readInt()-1;
            dis[u][v]=in.readInt();
        }
        /*
        out.println("---");
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                out.print(dis[i][j]+" ");
            }
            out.println();
        }
        
        out.println("---");*/
        
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    
                    if(dis[i][k]==Integer.MAX_VALUE || dis[k][j]==Integer.MAX_VALUE)
                        continue;
                    if(dis[i][j]>dis[i][k]+dis[k][j]){
                        dis[i][j]=dis[i][k]+dis[k][j];
                    }
                }
            }
        }
        
        int q = in.readInt();
        while(q-->0){
            int u = in.readInt()-1;
            int v = in.readInt()-1;
            if(dis[u][v]<Integer.MAX_VALUE){
                out.println(dis[u][v]);
            }else{
                out.println(-1);
            }
        }
        
        out.close();
        
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
    
void start() 
    {
        String s1 = "slip";
        String s2 = fix(s1);
        System.out.println(s1 + " " + s2);
    }

    String fix(String s1) 
    {
        s1 = s1 + "stream";
        System.out.print(s1 + " ");
        return "stream";
    }
}



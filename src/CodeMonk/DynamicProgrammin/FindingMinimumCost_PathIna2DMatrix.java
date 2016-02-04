/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CodeMonk.DynamicProgrammin;
import java.io.IOException;
import java.io.InputStream;
/**
 *
 * @author jaimin
 */
public class FindingMinimumCost_PathIna2DMatrix {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        
        int x = 5,y=5;
        int[][] arr = new int[x][y];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                arr[i][j]=in.readInt();
            }
        }
        
        FindingMinimumCost_PathIna2DMatrix f = new FindingMinimumCost_PathIna2DMatrix();
        
        
        System.out.println(f.minCost(arr, x, y));
        System.out.println(f.numWays(arr, x, y));
    }
    
    int minCost(int[][] arr,int x,int y){
        int[][] minCost = new int[x][y];
        
        minCost[0][0] = arr[0][0];
        
        for(int j=1;j<2;j++){
            minCost[0][j] = minCost[0][j-1]+arr[0][j];
        }
        for(int i=1;i<2;i++){
            minCost[i][0] = minCost[i-1][0]+arr[i][0];
        }
        
        for(int i=1;i<x;i++){
            for(int j=1;j<y;j++){
                minCost[i][j]= Math.min(minCost[i-1][j],minCost[i][j-1])+arr[i][j];
            }
        }
        
        return minCost[x-1][y-1];
    }
    
    int numWays(int[][] arr,int x,int y){
        int[][] Ways = new int[x][y];
        Ways[0][0]=1;
        
        for(int j=1;j<2;j++){
            Ways[0][j] = 1;
        }
        for(int i=1;i<2;i++){
            Ways[i][0] = 1;
        }
        
        for(int i=1;i<x;i++){
            for(int j=1;j<y;j++){
                Ways[i][j]=Ways[i-1][j]+Ways[i][j-1];
            }
        }
        return Ways[x-1][y-1];
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

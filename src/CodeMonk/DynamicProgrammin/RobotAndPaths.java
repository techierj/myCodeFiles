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
public class RobotAndPaths {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        
        int m = in.readInt();
        int n = in.readInt();
        int p = in.readInt();
        long[][] path = new long[m][n];
        
        while(p-->0){
            path[in.readInt()-1][in.readInt()-1]=-1;
        }
        
        if(path[0][0]==-1){
            System.out.println("0");
            return;
        }
        
        for(int i=0;i<m;i++){
            if(path[i][0]==0) path[i][0]=1;
            else break;
        }
        
        for(int j=1;j<n;j++){
            if(path[0][j]==0) path[0][j]=1;
            else break;
        }
        int i=1,j=1;
        for(i=1;i<m;i++){
            for(j=1;j<n;j++){
                if(path[i][j]==-1)continue;
                if(path[i-1][j]>0)path[i][j]=(path[i][j]+path[i-1][j]+1000000007)%1000000007;
                if(path[i][j-1]>0)path[i][j]=(path[i][j]+path[i][j-1]+1000000007)%1000000007;
            }
        }
        /*
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                System.out.print(path[i][j]+" ");
            }
            System.out.println();
        }*/
        System.out.print(path[m-1][n-1]>=0?path[m-1][n-1]:"0");
        
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

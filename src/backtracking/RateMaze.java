/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backtracking;
import java.io.IOException;
import java.io.InputStream;
/**
 *
 * @author jaimin
 */
public class RateMaze {
    public static void main(String[] args) throws IOException {
    
        RateMaze sol = new RateMaze();
        
        int[][] maze = 
           {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 1, 0},
            {1, 1, 1, 1}
        };
        
        sol.solveMaze(maze, 0, 0);
        
    }
    
    boolean solveMaze(int[][] maze,int i,int j){
        int[][] sol={{0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        
        if(solveMazeUtil(maze,i,j,sol)==false){
            System.out.println("Solution Doesn't Exist...");
            return false;
        }
        printMaze(sol);
        return true;
    }
    
    boolean solveMazeUtil(int[][] maze,int i,int j,int[][] sol){
        if(i==maze.length-1 && j==maze.length-1){
            sol[i][j]=1;
            return true;
        }
        
        if(isSafe(maze,i,j)){
            sol[i][j]=1;
            if(solveMazeUtil(maze, i+1, j, sol))
                return true;
            if(solveMazeUtil(maze, i, j+1, sol))
                return true;
            
            sol[i][j]=0;
            return false;
        }
        return false;
    }
    
    boolean isSafe(int[][] maze,int i,int j){
        if(i>=0 && i<maze.length && j>=0 && j<maze.length && maze[i][j]==1)
            return true;
        return false;
    }
    
    void printMaze(int[][] sol){
        for(int i=0;i<sol.length;i++){
            for(int j=0;j<sol.length;j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
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

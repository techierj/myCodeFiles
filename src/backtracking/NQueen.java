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
public class NQueen {
    public static void main(String[] args) throws IOException {
        
        NQueen queen = new NQueen();
        
        queen.solve(4);
    }
    
    boolean solve(int n){
        int [][] board = new int[n][n];
        
        buildBoard(board,n);
        
        if(solveUtil(board,0)==false){
            System.out.println("Solution Doesn't Exist...");
            return false;
        }
        printBoard(board);
        return true;
    }
    
    void buildBoard(int[][] board,int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=0;
            }
        }
    }
    
    boolean solveUtil(int[][] board,int col){
        if(col>=board.length){
            return true;
        }
        
        for(int i=0;i<board.length;i++){
            if(isSafe(board, i, col)){
                board[i][col]=1;
                if(solveUtil(board, col+1))
                    return true;
                board[i][col]=0;
            }
        }
        return false;
    }
    
    boolean isSafe(int[][] board,int row,int col){
        int i,j;
        
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
 
        /* Check upper diagonal on left side */
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1)
                return false;
 
        /* Check lower diagonal on left side */
        for (i=row, j=col; j>=0 && i<board.length; i++, j--)
            if (board[i][j] == 1)
                return false;
        
        return true;
    }
    
    void printBoard(int[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
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

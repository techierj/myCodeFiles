/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeMonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

/**
 *
 * @author jaimin
 */
public class TheConfusedMonk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        int n = in.readInt();
        
        long[] arr = new long[n];
        long fx = 1;
        for(int i=0;i<n;i++){
            arr[i] = in.readLong();
            fx*=arr[i]%1000000007;
        }
        
        long gcd = findGCD(arr,n);
        
        long ans = 1;
      //  System.out.println(fx+" "+gcd);
        
        while(gcd!=0){
            if(gcd%2==1){
                ans *=fx%1000000007;
            }
            fx*=fx%1000000007;
            gcd/=2;
        }
        
        System.out.print(ans);
        
        
        br.close();
        br = null;
    }
    
    public static long findGCD(long[] arr,int n){
        long result = arr[0];
        for(int i=1;i<n;i++){
            result = euclid(result,arr[i])%1000000007;
        }
        return result%1000000007;
    }
    
    public static long euclid(long a,long b){
        if(b==0){
            return a%1000000007;
        }else{
            return euclid(b,a%b)%1000000007;
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
        public final int readInt()throws IOException{return (int)readLong();}
        public final long readLong()throws IOException{
            int c=read();
            while(isSpaceChar(c)){
                c=read();
                if(c==-1) throw new IOException();
            }
            boolean negative=false;
            if(c=='-'){
                negative=true;
                c=read();
            }
            long res=0;
            do{
                if(c<'0'||c>'9')throw new InputMismatchException();
                res*=10;
                res+=(c-'0');
                c=read();
            }while(!isSpaceChar(c));
            return negative?(-res):(res);
        }
        public final int[] readIntBrray(int size)throws IOException{
            int[] arr=new int[size];
            for(int i=0;i<size;i++)arr[i]=readInt();
            return arr;
        }
        public final String readString()throws IOException{
            int c=read();
            while(isSpaceChar(c))c=read();
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
    
}

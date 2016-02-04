/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HeapsAndPriorityQueues;
import java.io.IOException;
import java.io.InputStream;
/**
 *
 * @author jaimin
 */
public class MonkAndMultiplication {
    int len ;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        int len = 0;
        int n = in.readInt();
        int[] arr=new int[n+2];
        
        MonkAndMultiplication obj = new MonkAndMultiplication();
        
        
        for(int i=1;i<=n;i++){
            obj.insertValue(arr,in.readInt(),i);
            obj.print(arr);
            sb.append(obj.getMax(arr,i)+"\n");
            //System.out.println(obj.getMax(arr, i));
        }
        System.out.print(sb);
        
    }
    
    
    void insertValue(int[] arr,int val,int i){
        len = i;
        arr[++len]=-1;
        incValue(arr,len,val);
    }
    
    void incValue(int[] arr,int i,int val){
        
        arr[i]=val;
        while(i>1 && arr[i/2]<arr[i]){
            swap(arr,i/2,i);
            i=i/2;
        }
    }
    
    
    long getMax(int[] arr,int i){
        if (i<3) {
            return -1;
        }
        
        int f = remove(arr);
        int s = remove(arr);
        int t = remove(arr);
        
        insertValue(arr, f, i);
        insertValue(arr, s, i);
        insertValue(arr, t, i);
        
        return (long)f*s*t;
    }
    
    int remove(int[] arr){
        int p=1,c=2;
        if(len==0) return -1;
        
        int max = arr[1];
        int temp = arr[len--];
        while(c<=len){
            
            if (c < len && arr[c]< arr[c+1])
                c++;
            if (temp>= arr[c])
                break;
 
            arr[p] = arr[c];
            p = c;
            c *= 2;
        }
        arr[p]=temp;
        return max;
    }
    
    
    void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
    void print(int[] arr){
        System.out.println("------\n");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println("\n\n------");
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

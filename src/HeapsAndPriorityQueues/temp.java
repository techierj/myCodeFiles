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
public class temp {
    static int len;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        len = 1;
        int t = in.readInt();
        int[] max = new int[100001];
        int[] min = new int[100001];
        temp obj = new temp();
        while(t-->0){
            int p = in.readInt();
            if(p==1){
                int val = in.readInt();
                obj.insertMaxValue(max, val);
                --len;
                obj.insertMinValue(min, val);
            }else if(p==2){
                int pos = obj.removeMax(max, in.readInt());
                if(pos!=-1){
                    obj.removeMin(min, len-pos-1);
                }
                
            }else if(p==3){
                System.out.println(max[1]);
            }else{
                System.out.println(min[2]);
            }
        }
        
        System.out.print(sb);
        
    }
    
    void insertMaxValue(int[] arr,int val){
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
    
    void insertMinValue(int[] arr,int val){
        arr[++len]=-1;
        decValue(arr,len,val);
    }
    
    void decValue(int[] arr,int i,int val){
        
        arr[i]=val;
        while(i>1 && arr[i/2]>arr[i]){
            swap(arr,i/2,i);
            i=i/2;
        }
    }
    
    int removeMax(int[] arr,int val){
        int i=1;
        for(;i<len;i++){
            if(arr[i]==val){
                arr[i]=-1;
                break;
            }
        }
        if(i>=len){
            System.out.println("-1");
            return -1;
        }
        int p=1,c=2;
        int max = arr[i];
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
        return i;
    }
    
    int removeMin(int[] arr,int i){
        
        int p=1,c=2;
        int max = arr[i];
        int temp = arr[len--];
        while(c<=len){
            if (c < len && arr[c]> arr[c+1])
                c++;
            if (temp<= arr[c])
                break;
 
            arr[p] = arr[c];
            p = c;
            c *= 2;
        }
        arr[p]=temp;
        return i;
    }
    
    void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    void print(int[] arr,int len){
        System.out.println("------\n");
        for(int i=1;i<len;i++){
            System.out.print(arr[i]+" "+i+"----");
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

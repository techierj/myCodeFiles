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
public class Minimum {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader in = new InputReader(System.in);
        
        int[] arr = {0,4, 5, 6, 7, 3, 2};
        
        Minimum min = new Minimum();
        //min.sortedMinHeap(arr,arr.length-1);
        
        System.out.println(min.extractMinimum(arr)); 
        min.print(arr);
       
    }
    
    void buildMinHeap(int[] arr,int n){
        for(int i=n/2;i>=1;i--){
            minHeapify(arr, i, n);
        }
    }
    
    void sortedMinHeap(int[] arr,int n){
        int heapSize = n;
        buildMinHeap(arr, n);
        for(int i=n;i>=2;i--){
            swap(arr, 1, i);
            heapSize = heapSize - 1;
            minHeapify(arr, 1,heapSize);
        }
    }
    
    void sortedMaxHeap(int[] arr,int n){
        int heapSize = n;
        buildMaxHeap(arr, n);
        for(int i=n;i>=2;i--){
            swap(arr, 1, i);
            heapSize = heapSize - 1;
            maxHeapify(arr, 1,heapSize);
        }
    }
    
    void minHeapify(int[] arr,int i,int n){
        int left = 2*i;
        int right = 2*i+1;
        int smallest;
        
        if(left<=n && arr[left]<arr[i]){
            smallest = left;
        }else{
            smallest = i;
        }
        
        if(right<=n && arr[right]<arr[smallest]){
            smallest = right;
        }
        
        if(smallest!=i){
            swap(arr,i,smallest);
            minHeapify(arr, smallest, n);
        }
        
    }
    
    int extractMinimum(int[] arr){
        int[] temp = new int[arr.length];
        temp = arr.clone();
        sortedMinHeap(temp, temp.length-1);
        return temp[temp.length-1];
    }
    
    int extractMaximum(int[] arr){
        int[] temp = new int[arr.length];
        temp = arr.clone();
        sortedMaxHeap(temp, temp.length-1);
        return temp[temp.length-1];
    }
    
    void print(int[] arr){
        System.out.println("------\n");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println("\n\n------");
    }
    
    void maxHeapify(int[] arr,int i,int n){
        int left = 2*i;
        int right=2*i+1;
        int largest;
        if(left<=n && arr[left]>arr[i]){
            largest = left;
        }else{
            largest = i;
        }
        if(right<=n && arr[right]>arr[largest]){
            largest = right;
        }
        
        if(largest != i){
            swap(arr, i, largest);
            maxHeapify(arr, largest, n);
        }
    }
    
    void buildMaxHeap(int[] arr,int n){
        for(int i=n/2;i>0;i--){
            maxHeapify(arr, i, n);
        }
    }
    
    void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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

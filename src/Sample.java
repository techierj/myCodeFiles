import java.io.*;
import java.util.*;

public class Sample {

    
    public static void main(String[] args) throws Exception{
        long startTime = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            long n = Long.parseLong(br.readLine());
            if(isPrime(n)){
                out.println("Prime");
            }else{
                out.println("Not prime");
            }
        }
        long endTime = System.currentTimeMillis();
        out.println(endTime-startTime+" ms");
        out.flush();
        out.close();
        br.close();
        
    }
    
    static boolean isPrime(long n){
        long upTo = n>>1;
        int count = 0;
        for(long i=2;i<upTo;i++){
            if(n%i==0){
                ++count;
                break;
            }
        }
        if(count>0 || n==1){
            return false;
        }
        return true;
    }
    
}
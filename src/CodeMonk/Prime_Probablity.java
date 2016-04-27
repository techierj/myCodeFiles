/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeMonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaimin
 */
public class Prime_Probablity {
    public static boolean[] prime = new boolean[1000002];
    
    public static void main(String[] args){
        try {
            new Prime_Probablity().findPrime(1000001);
            
            /*for(int i =2;i<1000000;i++){
            if(prime[i]==true){
            System.out.print(i+" ");
            }
            }*/
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(System.out);
            
            long[] total = new long[1000002];
            long j = 0;
            for(int i =0;i<=1000000;i++){
                if(prime[i]==true){
                    ++j;
                }
                total[i]=j;
            }
            prime = null;
//        for(int i=0;i<=12;i++){
//            System.out.print(i+"->"+total[i]+" ");
//        }
//        System.out.println("---");
            int t = Integer.parseInt(br.readLine());
            
            while(t-->0){
                String line[] = br.readLine().split(" ");
                
                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);
                double count = 0;
                if(total[a-1]<total[a] || total[b-1]<total[b]){
                    count = total[b]-total[a]+1;
                }else{
                    count = total[b]-total[a];
                }
                if(count<0) count*=-1;
                double ans = count/(b-a+1);
                // System.out.println(total[b]+" "+total[a]);
                out.println(String.format("%.6f", ans));
            }
            out.flush();
            out.close();
            br.close();
        } catch (IOException ex) {
            
        }
    }
    
    
    
    
    void findPrime(int n){
        
        for(int i=2;i<=1000000;i++){
            prime[i]=true;
        }
        
        for(int p=2;p*p<=n;p++){
            if(prime[p]==true){
                for(int i=p*2;i<=n;i+=p){
                    prime[i]=false;
                }
            }
        }
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeMonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author jaimin
 */
public class ChanduAndHisInterns {
    public static void main(String[] args) throws IOException {
        MyScanner br = new MyScanner();
        
        StringBuilder sb = new StringBuilder();
        int n = br.nextInt();
        boolean[] prime = countPrime(10000000);
      
        while(n-->0){
            int x = br.nextInt();
            
            boolean flag = false;
            int sqrt = (int) Math.sqrt(x);
            if(!prime[x]){
                sb.append("NO\n");
            }else if(sqrt*sqrt == x && !prime[sqrt]){
                sb.append("NO\n");
            }else{
                sb.append("YES\n");
            }
        }
        
        System.out.print(sb);
        
        br = null;
    }
    
    public static boolean[] countPrime(int n){
        boolean[] arr = new boolean[n+5];
        for(int i=2;i*i<=n;i++){
            if(!arr[i])
            {
               //System.out.print(i+" ");
               for(int j=i*2;j<=n;j+=i){
                   arr[j]=true;
               } 
            }
        }
        return arr;
    }

}

class MyScanner {
	   BufferedReader br;
	   StringTokenizer st;
	  
	   public MyScanner() {
	      br = new BufferedReader(new InputStreamReader(System.in));
	   }
	  
	   String next() {
	      while (st == null || !st.hasMoreElements()) {
	         try {
	            st = new StringTokenizer(br.readLine());
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	      }
	      return st.nextToken();
	   }
	  
	   int nextInt() {
	      return Integer.parseInt(next());
	   }
	  
	   long nextLong() {
	      return Long.parseLong(next());
	   }
	  
	   double nextDouble() {
	      return Double.parseDouble(next());
	   }
	  
	   String nextLine(){
	      String str = "";
	      try {
	         str = br.readLine();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      return str;
	   }
	 
	}
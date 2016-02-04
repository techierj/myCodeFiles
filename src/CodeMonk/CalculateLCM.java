/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeMonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jaimin
 */
public class CalculateLCM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        
        while(t-->0){
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            
            long sum = 0;
            
            for(int i=1;i<=a;i++){
                for(int j=1;j<=b;j++){
                    sum+=lcm(i,j)%1073741824;
                }
            }
            sb.append(sum+"\n");
        }
        
        System.out.print(sb);
        
        
        br.close();
        br = null;
    }
    
    public static long lcm(int a,int b){
        return ((a*b)/gcd(a,b)%1073741824);
    }
    
    public static long gcd(int a,int b){
        if(a==b){
            return a%1073741824;
        }
        if(a>b){
            return gcd(a-b,b)%1073741824;
        }
        return gcd(a,b-a)%1073741824;
    }
}

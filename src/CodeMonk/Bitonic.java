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
public class Bitonic {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        
        line = br.readLine().split(" ");
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
        arr[i]=Integer.parseInt(line[i]);
        }
        
        while(m-->0){
            String[] line1 = br.readLine().split(" ");
            int a = Integer.parseInt(line1[0]);
            int b = Integer.parseInt(line[1]);
            int flag = 0;
            int count = 0;
            
            for(int i=a-1;i<b;i++){
                if(arr[i]<arr[i+1]){
                    if(flag==0){
                        flag=1;
                    }else if(flag==-1){
                        count++;
                        flag=1;
                    }
                }else{
                    if(flag==0){
                        flag=-1;
                    }else if(flag==1){
                        count++;
                        flag=-1;
                    }
                }
                
                if(count>2 || (flag==1 && count==1)){
                    break;
                }
            }
            
            if(count>2){
                sb.append("No\n");
            }else{
                sb.append("Yes\n");
            }
        }
        
        System.out.print(sb);
    }
}

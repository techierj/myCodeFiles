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
public class TheOldMonk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            
            String[] line = br.readLine().split(" ");
            String[] line2 = br.readLine().split(" ");
            
            long[] arr = new long[n];
            long[] arr2 = new long[n];
            
            for(int i=0;i<n;i++){
                arr[i] = Long.parseLong(line[i]);
                arr2[i] = Long.parseLong(line2[i]);
            }
            
            long ans = 0;
            for(int i=0;i<n;i++){
                //long num = arr[i];
                int start = i,end=n-1,mid=0;
                //int j=i+1;
                while(start<=end){
                    mid = (start+end)/2;
                    if(arr2[mid]>=arr[i]){
                        ans = mid - i;
                        start = mid + 1;
                    }else{
                        end = mid - 1;
                    }
                }
                sb.append(ans+"\n");
            }
        }
        
        System.out.print(sb);
        
        
        br.close();
        br = null;
    }
}

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
public class MergTwoSorted {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            
            String[] str_arr = br.readLine().split(" ");
            String[] str_arr2 = br.readLine().split(" ");
            
            int[] arr = new int[n];
            int[] arr2 = new int[m];
            
            int rem = 0;
            
            if(n>m){
                for(int i=0;i<m;i++){
                    arr[i]=Integer.parseInt(str_arr[i]);
                    arr2[i]=Integer.parseInt(str_arr2[i]);
                }
                for(int i=m;i<n;i++){
                    arr[i]=Integer.parseInt(str_arr[i]);
                }
                
            }else{
                for(int i=0;i<n;i++){
                    arr[i]=Integer.parseInt(str_arr[i]);
                    arr2[i]=Integer.parseInt(str_arr2[i]);
                }
                for(int i=n;i<m;i++){
                    arr2[i]=Integer.parseInt(str_arr2[i]);
                }
            }
            
            
            
            int i=0,j=0;
            
            while(i<n && j<m){
                if(arr[i]>arr2[j]){
                    System.out.print(i+"__");
                    sb.append(arr[i++]+" ");
                }else{
                    System.out.print(j+"..");
                    sb.append(arr2[j++]+" ");
                }
            }
            if(n>m){
                for(i=m;i<n;i++){
                    sb.append(arr[i]+" ");
                }
            }else{
                for(i=n;i<m;i++){
                    sb.append(arr2[i]+" ");
                }
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
        
        
        br.close();
        br = null;
    }
}

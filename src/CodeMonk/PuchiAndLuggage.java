/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeMonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author jaimin
 */
public class PuchiAndLuggage {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(br.readLine());
            }
            for(int i=0;i<n;i++){
                
            }
            
            
        }
        
        System.out.print(sb);
        
        
        br.close();
        br = null;
    }
    
    
}

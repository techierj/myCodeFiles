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
public class IndiaHacks_Pb_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            
            String[] line = br.readLine().split(" ");
            
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(line[i]);
            }
            boolean flag = false;
            int pos = 0;
            while(n-->0){
                if(arr[pos]==-1){
                    flag = true;
                    break;
                }
                pos = arr[pos];
            }
            if(flag){
                sb.append("Win\n");
            }else{
                sb.append("Lose\n");
            }
        }
        
        System.out.print(sb);
        
        
        br.close();
        br = null;
    }
}

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
public class atTheEnd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int count = 0;
            for(int i =0;i<n;i++){
                count = count+(Integer.parseInt(line[i]));
            }
            
            if(count%4==0){
                sb.append((count/4)+"\n");
            }else{
                sb.append((count/4)+1+"\n");
            }
            
            
        }
        
        System.out.print(sb);
        br.close();
        br = null;
    }
}

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
public class Songs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        while(t-->0){
            String[] line =br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            
            line = br.readLine().split(" ");
            int joke = 0;
            for(int i=0;i<n;i++){
                m-=Integer.parseInt(line[0])-10;
                joke+=2;
                
                if(m<0){
                    break;
                }
            }
            if(m>=0){
                sb.append(joke+"\n");
            }else{
                sb.append("-1\n");
            }
            
        }
        
        br.close();
        br = null;
    }
}

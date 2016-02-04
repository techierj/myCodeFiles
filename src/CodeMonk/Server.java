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
public class Server {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            
            String[] line = br.readLine().split(" ");
            int server = 0,count=0;
            
            for(int i=0;i<n;i++){
                int a = Integer.parseInt(line[i]);
                
                if(a<0){
                    if(server==0){
                        count++;
                    }else{
                        --server;
                    }
                }else {
                    server+=a;
                }
            }
            sb.append(count+"\n");
        }
        System.out.print(sb);
        br.close();
    }
}

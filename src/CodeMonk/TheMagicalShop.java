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
public class TheMagicalShop {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] line = br.readLine().split(" ");
        long a = Long.parseLong(line[0]);
        long b = Long.parseLong(line[1]);
        
        String read = br.readLine();
        int len = read.length();
        long ans = 0;
        for(int i=0;i<len;i++){
            if(read.charAt(i)=='1'){
                ans=(ans+a)%b;
            }
            a=(a*a)%b;
            
        }
        
        System.out.print(ans);
        
        
        br.close();
        br = null;
    }
}

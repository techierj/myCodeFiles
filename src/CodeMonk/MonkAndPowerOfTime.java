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
public class MonkAndPowerOfTime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        String[] arr = br.readLine().split(" ");
        String[] arr2 = br.readLine().split(" ");
        
        int front = 0;
        int rear = n;
        int count = 0;
        
        for(int i=0;i<n;i++){   
          //  System.out.print(arr[front]+" "+arr2[i]+"\n");
            while(!arr[front].equals(arr2[i])){
              // System.out.print(arr[front]+".."+arr2[i]+"\n");
                if(arr[front]=="-1") {
                    front = (1+front)%n;
                    continue;
                }
                    front = (1+front)%n;
                   // rear = (1+rear)%n;
                    ++count;
                    //System.out.print(front);
                }
            arr[front]="-1";
            front = (1+front)%n;
            ++count;
            }
        
        System.out.print(count);
        
        
        br.close();
        br = null;
    }
}

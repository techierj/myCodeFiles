package CodeMonk;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
/**
 *
 * @author jaimin
 */
public class MonksEncounterWithPolynomial{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String[] line = br.readLine().split(" ");
            long a = Long.parseLong(line[0]);
            long b = Long.parseLong(line[1]);
            long c = Long.parseLong(line[2]);
            long k = Long.parseLong(line[3]);
            
            long start = 0,end=100000,mid,ans=-1;
            
            
            while(start<=end){
                mid = (start+end)/2;
                long val = a*mid*mid + b*mid + c;
                if(val>=k){
                    ans = mid;
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
            sb.append(ans+"\n");
            
        }
        
        System.out.print(sb);
        
        
        br.close();
        br = null;
    }
}
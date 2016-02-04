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
public class MonkInTheGrassFields {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            
            int[] row = new int[n];
            int[] col = new int[n];
            
            for(int i=0;i<n;i++){
                line = br.readLine().split(" ");
                for(int j=0;j<n;j++){
                    row[i] += Integer.parseInt(line[j]);
                    col[j] += Integer.parseInt(line[j]);
                }
            }
            
            int[] r2 = new int[n*1000];
            int[] c2 = new int[n*1000];
            
            long ans = Long.MAX_VALUE;
            
            for(int i=1;i<=k;i++){
                row = sort(row,0,n-1);
                col = sort(col,0,n-1);
                
                
                int small= row[0];
                row[0] = small+n;
                r2[i] = r2[i-1]+small;
                small = col[0];
                c2[i]=c2[i-1]+small;
                col[0]=small+n;
                
            }
            
            for(int i=0;i<=k;i++){
               // System.out.println(ans+" ");
                ans = Math.min(ans, r2[i]+c2[k-i]+i*(k-i));
            }
            sb.append(ans+"\n");
        }
        
        
        
        System.out.print(sb);
        
        
        br.close();
        br = null;
    }
    
    public static int[] sort(int[] arr,int start,int end){
    	if(start<end){
    		int mid = (start + end) / 2;
    		sort(arr,start,mid);
    		sort(arr,mid+1,end);
    		
    		merge(arr,start,mid,end);
    		
    		
    	}
    	return arr;
    }
    
    public static void merge(int[] arr,int start,int mid,int end){
    	int p=start,q=mid+1,k=0;
    	
    	int arr2[] = new int[end-start+1];
    	
    	for(int i=start;i<=end;i++){
    		if(p>mid){
    			arr2[k++]=arr[q++];
    		}else if(q>end){
    			arr2[k++]=arr[p++];
    		}else if(arr[q]<arr[p]){
    			arr2[k++]=arr[q++];
    		}else{
    			arr2[k++]=arr[p++];
    		}
    	}
    	
    	for(p=0;p<k;p++){
    		arr[start++]=arr2[p];
    	}
    	
    }
}

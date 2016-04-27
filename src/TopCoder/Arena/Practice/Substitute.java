/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TopCoder.Arena.Practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
/**
 *
 * @author jaimin
 */
public class Substitute {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String key = br.readLine();
        String code = br.readLine();
        
        out.println(getValue(key,code));
        
        out.flush();
        br.close();
        out.close();
    }
    
    static int getValue(String key,String code){
        int len = code.length();
        int last = 10;
        String ans = "";
        int keyLen = key.length();
        for(int i=0;i<len;i++){
            for(int j=0;j<keyLen;j++){
                if(code.charAt(i)==key.charAt(j)){
                    ans += ((j+1)%10);
                    last*=10;
                    break;
                }
            }
        }
        return Integer.parseInt(ans);
    }
    
}

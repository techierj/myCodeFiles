/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

/**
 *
 * @author jaimin
 */
public class rais {
    public static void main(String[] args) {
        
        
        
        double a = 106.25;
        int b = 68;
        double ans=1;
        
        while(b!=0){
            ans*=a;
            b--;
        }
        
        System.out.println(ans);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author jaimin
 */
public class Addition {
 
    public static void main(String[] args) {
        Random randomNum = new Random();
        String first = "";
        String second = "";
        for(int i=0;i<1000;i++){
            int f_rd = (int) (Math.random()*9);
            int s_rd = (int) (Math.random()*9);
            
            first+=f_rd;
            second+=s_rd;
        }
        
        
        BigInteger f = new BigInteger(first);
        BigInteger s = new BigInteger(second);
        
        
        System.out.println(f.add(s));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author jaimin
 */
public class PrattAndOffice {
static int prime = 0;
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        int t = numberOfTest(100);
        out.println(t);
        while (t-- > 0) {
            int n = numberOfTest(1000);
            int m = numberOfTest(n);
            out.println(n+" "+m);
            while(m-->0){
                out.println(numberOfTest(n)+" "+numberOfTest(n));
            }
        }
        out.flush();
        out.close();
    }

    static int numberOfTest(int upto) {
        int t = 1 + (int)(Math.random() * upto); 
        return t;
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaimin
 */
public class sleepExample extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            
            System.out.println(i);
        }
    }
    
    public static void main(String[] args) {
        sleepExample t1 = new sleepExample();
        sleepExample t2 = new sleepExample();
        
        t1.start();
        t2.start();
    }
}

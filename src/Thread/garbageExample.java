/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

/**
 *
 * @author jaimin
 */
public class garbageExample {
    public void finalize(){
        System.out.println("Finalize method called...");
    }
    
    public static void main(String[] args) {
        garbageExample g1 = new garbageExample();
        garbageExample g2 = new garbageExample();
        
        g1 = null;
        g2 = null;
        
        System.gc();
    }
}

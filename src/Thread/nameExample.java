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
public class nameExample extends Thread{
    
    public void run(){
        System.out.println("Running...");
    }
    public static void main(String[] args) {
        nameExample t1 = new nameExample();
        nameExample t2 = new nameExample();
        
        System.out.println("Name of Thread t1 :"+t1.getName());
        System.out.println("Name of Thread t2 : "+t2.getName());
        
        System.out.println("Id of t1 : "+t1.getId());
        t1.start();
        t2.start();
        
        System.out.println("after changeing the name");
        t1.setName("Jaimin");
        System.out.println("t1 :"+t1.getName());
        
        System.out.println(Thread.currentThread().getName());
    }
    
}

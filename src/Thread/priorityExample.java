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
public class priorityExample extends Thread{
    
    public void run(){
        System.out.println("Current thread name and priority : "+Thread.currentThread().getName()+" : "+Thread.currentThread().getPriority());
    }
    
    public static void main(String[] args) {
        priorityExample t1 = new priorityExample();
        priorityExample t2 = new priorityExample();
        
        
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
    
}

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
public class ThreadExample2 implements Runnable{
    public void run(){
        System.out.println("Thread is Running...");
    }
    
    public static void main(String[] args) {
        ThreadExample2 t1 = new ThreadExample2();
        Thread t2 = new Thread(t1);
        t2.start();
    }
}

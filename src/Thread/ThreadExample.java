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
public class ThreadExample extends Thread{
    public void run(){
        System.out.println("Thread is running...");
    }
    
    public static void main(String[] args) {
        ThreadExample t1 = new ThreadExample();
        t1.start();
    }
}

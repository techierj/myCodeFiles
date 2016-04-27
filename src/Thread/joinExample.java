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
public class joinExample extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
    
    public static void main(String [] args){
        joinExample t1 = new joinExample();
        joinExample t2 = new joinExample();
        joinExample t3 = new joinExample();
        
        t1.start();
        try{
            t1.join(1500);
        }catch(Exception e){
            System.err.println(e);
        }
        
        t2.start();
        t3.start();
        
    }
}

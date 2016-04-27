/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author jaimin
 */
public class iterator {
    public static void main(String []args){
        LinkedList<String> ll = new LinkedList<String>();
        
        ll.add("jaimin");
        ll.add("g.");
        ll.add("shah");
        
        Iterator it = ll.iterator();
        
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}

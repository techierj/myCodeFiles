/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedHashSet;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 *
 * @author jaimin
 */
public class linkedhashset_example {
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<String>();
        
        lhs.add("jaimin");
        lhs.add("G.");
        lhs.add("G.");
        lhs.add("Shah");
        
        Iterator itr = lhs.iterator();
        
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashSet;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author jaimin
 */
public class hashsetExample {
    public static void main(String [] args){
        HashSet<String> hs = new HashSet<String>();
        
        hs.add("Jaimin");
        hs.add("Jaimin");
        hs.add("G.");
        hs.add("G.");
        hs.add("Shah");
        
        Iterator it =hs.iterator();
        
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}

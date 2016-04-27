/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreeSet;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author jaimin
 */
public class treesetExample {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<String>();
        
        ts.add("Jaimin");
        ts.add("G.");
        ts.add("Shah");
        ts.add("G.");
        
        Iterator itr = ts.iterator();
        
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
    }
}

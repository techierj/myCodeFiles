/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author jaimin
 */
public class forward_previous {
    public static void main(String[] args){
        List<String> arr = new ArrayList<String>();
        
        arr.add("jaimin");
        arr.add("G.");
        arr.add("Shah");
        
        ListIterator<String> it = arr.listIterator();
        
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        
        System.out.println();
        
        while(it.hasPrevious()){
            System.out.print(it.previous()+" ");
        }
    }
}

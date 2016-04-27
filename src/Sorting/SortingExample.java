/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author jaimin
 */
public class SortingExample {
    public static void main(String[] args) {
        
        ArrayList<String> arr =new ArrayList<String>();
        
        arr.add("Naitik");
        arr.add("Jaimin");
        arr.add("Radhu");
        
        Collections.sort(arr);
        
        Iterator itr = arr.iterator();
        
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}

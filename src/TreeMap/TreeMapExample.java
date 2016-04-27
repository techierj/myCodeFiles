/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreeMap;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author jaimin
 */
public class TreeMapExample {
    public static void main(String[] args) {
        
        TreeMap<Integer,String> tm = new TreeMap<Integer,String>();
        
        tm.put(1, "Jaimin");
        tm.put(3, "Shah");
        tm.put(2, "G.");
        
        for(Map.Entry m:tm.entrySet()){
            System.out.println(m.getKey()+ " : "+m.getValue());
        }
    }
}

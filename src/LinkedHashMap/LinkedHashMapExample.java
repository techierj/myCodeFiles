/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author jaimin
 */
public class LinkedHashMapExample {
    public static void main(String[] args) {
        
        LinkedHashMap<Integer,String> lhm = new LinkedHashMap<Integer,String>();
        
        lhm.put(1,"Jaimin");
        lhm.put(3, "G.");
        lhm.put(2, "Shah");
        
        for(Map.Entry m :lhm.entrySet()){
            System.out.println(m.getKey()+" : "+m.getValue());
        }
    }
}

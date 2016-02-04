/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jaimin
 */
public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer,String> hm = new HashMap<Integer,String>();
        
        hm.put(1,"Jaimin");
        hm.put(3, "G.");
        hm.put(2, "Shah");
        
        for(Map.Entry m:hm.entrySet()){
            System.out.print(m.getKey()+":"+m.getValue()+" ");
        }
    }
}

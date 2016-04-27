/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author jaimin
 */
public class SerializationExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Student s1 = new Student(120,"Jaimin");
        
        FileOutputStream fout = new FileOutputStream("text.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        
        String s ="jaimin";
        byte[] b = s.getBytes();
        
        fout.write(b);
        fout.flush();
        System.out.println("Success");
    }
}

class Student implements Serializable{
    int id;
    String name;
    
    public Student(int id,String name){
        this.id = id;
        this.name = name;
    }
    
    
}

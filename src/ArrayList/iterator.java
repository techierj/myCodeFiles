/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jaimin
 */
public class iterator {
    

    public static void main(String[] args){
    ArrayList<String> arr = new ArrayList<String>();
    
    arr.add("jaimin");
    arr.add("G.");
    arr.add("Shah");
    
    //show_it(arr);
    //show_for(arr);
    
    Student st = new Student(1207011,"Jaimin",20);
    Student st2 = new Student(1207020,"Radhu",20);
    
    ArrayList<Student> arr2 = new ArrayList<Student>();
    arr2.add(st);
    arr2.add(st2);
    
    Iterator it = arr2.iterator();
    while(it.hasNext()){
            Student std = (Student) it.next();
            
            System.out.print(std.name+" "+std.rollno+" "+std.age+"\n");
        }
    }
    
    public static void show_it(ArrayList<String> arr){
        Iterator it = arr.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
    
    public static void show_for(ArrayList<String> arr){
        for(String obj:arr){
            System.out.print(obj+" ");
        }
    }
    
    
}

class Student{
    int rollno;
    String name;
    int age;
    
    Student(int rollno,String name,int age){
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }
  }

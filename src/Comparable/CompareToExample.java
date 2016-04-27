/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author jaimin
 */
public class CompareToExample {
    public static void main(String[] args) {
        ArrayList<Student> arr = new ArrayList<Student>();
        
        arr.add(new Student(120,"jaimin",22));
        arr.add(new Student(150, "Radhu", 20));
        
        Collections.sort(arr);
        Iterator itr = arr.iterator();
        
        while(itr.hasNext()){
            Student st =(Student) itr.next();
            System.out.println(st.id+" : "+st.name+" : "+st.age);
        }
    }
}


class Student implements Comparable{
    int id;
    String name;
    int age;
    
    Student(int id,String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    public int compareTo(Object obj){
        
        Student st = (Student)obj;
        
        if(age == st.age)
            return 0;
        else if(age>st.age)
            return 1;
        else
            return -1;
    }
}
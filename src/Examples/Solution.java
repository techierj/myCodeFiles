package Examples;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Base{
    int value = 0;
    Base(){
        addValue();
    }
    void addValue(){
        value += 10;
    }
    int getValue(){
        return value;
    }
}
class Derived extends Base{
    Derived(){
        addValue();
    }
    void addValue(){
        value +=  30;
    }
}

class Student {

    private int token;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.token = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getToken() {
        return token;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class Solution extends Thread{

    public void run() {
        System.out.println("Hacker");
    }
    public void run(String s) {
        System.out.println("Earth");
    }
    
    
    public static void main(String[] args) {
        Derived b= new Derived();
        System.out.println(b.getValue());
        ArrayList al = new ArrayList();
            al.add("A");
            al.add(0, "B");
            al.add(null);
            System.out.println(al.size());
            new Solution().start();
        Scanner in = new Scanner(System.in);
        int totalEvents = Integer.parseInt(in.nextLine());
        Queue<Student> queue;
        queue = new PriorityQueue<>(totalEvents, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getCgpa() != o2.getCgpa()) {
                    if (o1.getCgpa() > o2.getCgpa()) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else if (o1.getFname().compareTo(o2.getFname()) != 0) {
                    return o1.getFname().compareTo(o2.getFname());
                } else {
                    return o1.getToken() - o2.getToken();
                }
            }
        });
        while (totalEvents > 0) {
            String event = in.next();
            if (event.equals("ENTER")) {
                String name = in.next();
                Double cgpa = in.nextDouble();
                int token = in.nextInt();
                queue.add(new Student(token, name, cgpa));
            } else {
                if (!queue.isEmpty()) {
                    queue.poll();
                }
            }
            totalEvents--;
        }
        
        if(queue.isEmpty()){
            System.out.println("EMPTY");
        }
        while(!queue.isEmpty()){
            System.out.println(queue.poll().getFname());
        }
        
    }
}

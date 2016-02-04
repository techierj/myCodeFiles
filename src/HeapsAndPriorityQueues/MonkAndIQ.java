/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HeapsAndPriorityQueues;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 *
 * @author jaimin
 */
public class MonkAndIQ {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int c = Integer.parseInt(line[0]);
        int p = Integer.parseInt(line[1]);
        int n = Integer.parseInt(line[2]);
        
        Queue<Course> course = new PriorityQueue<Course>();
        line = br.readLine().split(" ");
        int len = line.length;
        for(int i=1;i<=len;i++){
            Course temp = new Course(i);
            temp.addStu(Integer.parseInt(line[i-1]));
            course.add(temp);
        }
        
        //int rem = c-n;
        for(int i=len+1;i<=c;i++){
            Course temp = new Course(i);
            course.add(temp);
        }
       
       line = br.readLine().split(" ");
       len = line.length;
        for(int i=0;i<len;i++){
           Course temp = course.poll();
            //System.out.print(temp.crsNo+" "+temp.iq1+" "+temp.iq2+" "+temp.z+"--");
            temp.addStu(Integer.parseInt(line[i]));
            System.out.printf("%d " , temp.crsNo);
            course.add(temp);
            //System.out.println(temp.crsNo+" "+temp.z);
        }
        
        System.out.print(sb);
    }
    
}

class Course implements Comparable<Course>{
    int crsNo,iq1,iq2,totalStu;
    long z;
    boolean flag;
    
    public Course(int crsNo){
        this.crsNo = crsNo;
        this.iq1 = 0;
        this.iq2 = 0;
        this.totalStu = 0;
        this.flag = false;
    }
    
    public void addStu(int IQ){
        if(!flag){
            this.iq1=IQ;
            flag=true;
        }else{
            this.iq2=IQ;
            flag=false;
        }
        totalStu++;
        computeZ();     
    }
    
    void computeZ(){
        this.z = totalStu *(iq1+iq2);
    }

        @Override
        public int compareTo(Course o) {
            if(this.z!=o.z)
                return (int)(this.z-o.z);
            else
                return this.crsNo-o.crsNo;
        }
    
    }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeMonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jaimin
 */
public class MonksLoveForFood {
    public static LinkedList ll;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ll = new LinkedList();
        
        int q = Integer.parseInt(br.readLine());
        while(q-->0){
            String line = br.readLine();
            
            if(line.charAt(0)=='1'){
                sb.append(ll.pop()+"\n");
            }else{
                String[] line2 = line.split(" ");
                ll.push(line2[1]);
            }
        }
        
        System.out.print(sb);
        
        br.close();
        br = null;
    }
}

    class Node{
        String val; 
        Node next;
        
        public Node(){}
    }

    class LinkedList{
        private Node head ;
        
        public LinkedList(){
            head = new Node();
        }
        
        public void push(String c){
            if(head == null ){
                Node temp = new Node();
                temp.val = c;
                head = temp;
            }else{
                Node temp = new Node();
                temp.val = c;
                temp.next = head;
                head = temp;
            }
            
        }
    
        public String pop(){
            String val="";
            if(head.val==null){
                val = "No Food";
                return val;
            }else{
                val = head.val;
               // System.out.println(val);
                head = head.next;
            }
        return val;
        }
        
    }

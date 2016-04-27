/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spoj;

import java.util.Scanner;

/**
 *
 * @author jaimin
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        while(flag==false){
            int a = in.nextInt();
            if(a!=42){
                System.out.println(a);
            }else{
                flag = true;
            }
        }
    }
}

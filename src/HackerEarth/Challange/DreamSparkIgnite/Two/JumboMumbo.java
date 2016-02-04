/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackerEarth.Challange.DreamSparkIgnite.Two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 *
 * @author jaimin
 */
public class JumboMumbo {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        JumboMumbo jm = new JumboMumbo();
        
        int t = Integer.parseInt(br.readLine());
        ++t;
        for(int i=1;i<t;i++){
            String[] line = br.readLine().split(" ");
            double c = Double.parseDouble(line[0]);
            double f = Double.parseDouble(line[1]);
            double x = Double.parseDouble(line[2]);
            
            sb.append("Case #"+i+": "+jm.getTime(c,f,x)+"\n");
        }
        System.out.print(sb);
        br.close();
        br = null;
    }
    
    String getTime(double c,double f,double x){
        DecimalFormat df = new DecimalFormat("#.0000000");
        double t1 = x/2;
        double t2 = x/(2+f);
        double time = 0,gen =2,s=0,count=1;
        while(t2<t1){
            time +=(c/gen);
            gen+=f;
            s = s-(c);
        }
        time+=(x/gen);
        return df.format(time);
    }
    
}

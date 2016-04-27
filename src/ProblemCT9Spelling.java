/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 *
 * @author jaimin
 */
public class ProblemCT9Spelling {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Character, String> map = new HashMap<>();

        String[] arr = {"2", "22", "222", "3", "33", "333",
            "4", "44", "444", "5", "55", "555", "6", "66", "666",
            "7", "77", "777", "7777", "8", "88", "888", "9", "99", "999", "9999"};

        int n = Integer.parseInt(br.readLine());

        for (int k = 1; k <= n; k++) {
            out.print("Case #" + k + ": ");
            String s = br.readLine();
            int len = s.length();
            char prv = '_';
            for (int i = 0; i < len; i++) {

                String temp = "";
                if (s.charAt(i) != ' ') {
                    temp = arr[s.charAt(i) - 97];
                }else{
                    temp = "0";
                }
                if (temp.charAt(0) == prv) {
                    out.print(" ");
                }

                if (s.charAt(i) == ' ') {
                    out.print(0);
                } else {
                    out.print(temp);
                }
                prv = temp.charAt(0);
            }
            out.println();
        }

        br.close();
        br = null;
        out.flush();
        out.close();

    }

}

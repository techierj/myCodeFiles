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

/**
 *
 * @author jaimin
 */
public class ProblemBReverseWords {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int k = 1; k <= n; k++) {
            String s = br.readLine();
            String[] arr = s.split(" ");
            int len = arr.length - 1;
            out.print("Case #" + k + ": ");

            for (int i = len; i >= 0; i--) {
                out.print(arr[i] + " ");
            }
            out.println();
        }
        br.close();
        br = null;
        out.flush();
        out.close();
    }

}

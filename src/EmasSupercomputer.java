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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author jaimin
 */
public class EmasSupercomputer {

    static int N;
    static int M;
    static int maxPro;

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        N = n;
        M = m;
        maxPro = 0;
        List<Node> list = new ArrayList<Node>();

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        int[][] ans = new int[n][m];

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 'G') {
                ans[0][j] = 1;
                list.add(new Node(0, j, 1));
            }
            if (grid[n - 1][j] == 'G') {
                ans[n - 1][j] = 1;
                list.add(new Node(n - 1, j, 1));
            }
        }
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 'G') {
                ans[i][0] = 1;
                list.add(new Node(i, 0, 1));
            }
            if (grid[i][m - 1] == 'G') {
                ans[i][m - 1] = 1;
                list.add(new Node(i, m - 1, 1));
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 'G') {
                    if (grid[i + 1][j] == 'G' && grid[i][j + 1] == 'G' && grid[i - 1][j] == 'G' && grid[i][j - 1] == 'G') {
                        ans[i][j] = Math.min(ans[i - 1][j], ans[i][j - 1]) + 1;
                    } else {
                        ans[i][j] = 1;
                    }
                    list.add(new Node(i, j, ans[i][j]));
                    /*if(ans[i][j]>max){
                     sMax=max;
                     max=ans[i][j];
                     }else if(ans[i][j]>sMax){
                     sMax=ans[i][j];
                     }*/
                }
            }
        }

        Node[] arr = new Node[list.size()];
        list.toArray(arr);
        int len = arr.length;
        /*
         for (int i = 0; i < len - 1; i++) {
         for (int j = i + 1; j < len; j++) {
         for (int k = 0; k < 2; k++) {
         out.print(arr[j].count + " ");
         }
         out.println();
         }
         out.println("\n---");
         }
         out.println();
         */
        printCombination(arr, len, 2);
        /*
         for (Node i : arr) {
         out.print(i.count + " ");
         }*/
        out.println(maxPro);
        out.flush();
        out.close();
        br.close();
    }

    static void combinationUtil(Node arr[], int n, int r, int index,
            Node data[], int i) {
        if (index == r) {
            try {
                int count2 = 0;
                int tempPro = 0;
                boolean[][] visited = new boolean[N][M];

                for (int j = 0; j < r; j++) {
                    int count = 0;
                    if (!visited[data[j].i][data[j].j]) {
                        if (!visited[data[j].i][data[j].j]) {
                            ++count;
                        }
                        for (int z = 1; z < data[j].val; z++) {
                            if (!visited[data[j].i - z][data[j].j]) {
                                ++count;
                            }
                            if (!visited[data[j].i + z][data[j].j]) {
                                ++count;
                            }
                            if (!visited[data[j].i][data[j].j - z]) {
                                ++count;
                            }
                            if (!visited[data[j].i][data[j].j + z]) {
                                ++count;
                            }

                        }
                        if (count == data[j].count) {
                            visited[data[j].i][data[j].j] = true;
                            for (int z = 1; z < data[j].val; z++) {
                                visited[data[j].i - z][data[j].j] = true;
                                visited[data[j].i + z][data[j].j] = true;
                                visited[data[j].i][data[j].j - z] = true;
                                visited[data[j].i][data[j].j + z] = true;
                            }
                            ++count2;
                        }
                        if (count2 == 1) {
                            tempPro = data[j].count;
                        } else {
                            tempPro *= data[j].count;
                            if (tempPro > maxPro) {
                                maxPro = tempPro;
                            }
                        }
                    }
                    /*
                     for(boolean[] tt:visited){
                     for(boolean ttt:tt){
                     System.out.print(ttt+" ");
                     }
                     System.out.println();
                     }
                     System.out.println(tempPro+".."+count2);*/
                }

                return;
            } catch (Exception e) {
            }
        }
        if (i >= n) {
            return;
        }
        data[index] = arr[i];
        combinationUtil(arr, n, r, index + 1, data, i + 1);
        combinationUtil(arr, n, r, index, data, i + 1);
    }

    static void printCombination(Node arr[], int n, int r) {
        Node data[] = new Node[r];
        combinationUtil(arr, n, r, 0, data, 0);
    }

}

class Node {

    int i;
    int j;
    int val;
    int count;

    Node(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
        if (val <= 1) {
            this.count = val;
        } else {
            this.count = 2 * val + 1;
        }
    }
}

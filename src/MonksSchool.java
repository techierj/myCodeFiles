/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jaimin
 */
public class MonksSchool {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);

        int n = in.readInt();
        int m = in.readInt();

        Map<String, Integer> teacherMap = new HashMap<String, Integer>();
        List<String> teacher = new ArrayList<String>();

        List<ClassRoom>[] list = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<ClassRoom>();
        }

        for (int i = 0; i < n; i++) {
            String temp = in.readString();
            teacher.add(temp);
        }

        Collections.sort(teacher);

        for (int i = 0; i < n; i++) {
            String temp = teacher.remove(0);
            //out.println(temp);
            teacherMap.put(temp, i);
        }

        while (m-- > 0) {
            String tName = in.readString();
            String sName = in.readString();
            long age = in.readLong();

            list[teacherMap.get(tName)].add(new ClassRoom(tName, sName, age));

        }

        for (int i = 0; i < n; i++) {
            out.println(list[i].get(0).teacherName);
            List<ClassRoom> studentSort = new ArrayList<>();
            studentSort.addAll(list[i]);
            
            Collections.sort(studentSort, new Comparator<ClassRoom>() {

                @Override
                public int compare(ClassRoom o1, ClassRoom o2) {
                    if (o1.age != o2.age) {
                        if (o1.age > o2.age) {
                            return 1;
                        } else if (o2.age > o1.age) {
                            return -1;
                        } else {
                            return 0;
                        }
                    } else {
                        return compare(o1, o2);
                    }
                }
            });
            while(!studentSort.isEmpty()){
                ClassRoom temp = studentSort.remove(0);
                out.println(temp.studentName+" "+temp.age);
            }
        }

        out.flush();
        out.close();
    }

    static class ClassRoom  {

        String teacherName;
        String studentName;
        long age;

        ClassRoom(String t, String s, long a) {
            teacherName = t;
            studentName = s;
            age = a;
        }

    }

    static final class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() throws IOException {
            if (curChar >= numChars) {
                curChar = 0;
                numChars = stream.read(buf);
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public final int readInt() {
            return (int) readLong();
        }

        public final long readLong() {
            int c = 0;
            try {
                c = read();
            } catch (IOException ex) {
            }
            while (isSpaceChar(c)) {
                try {
                    c = read();
                } catch (IOException ex) {
                }
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                try {
                    c = read();
                } catch (IOException ex) {
                }
            }
            long res = 0;
            do {
                if (c < '0' || c > '9');
                res *= 10;
                res += (c - '0');
                try {
                    c = read();
                } catch (IOException ex) {
                }
            } while (!isSpaceChar(c));
            return negative ? (-res) : (res);
        }

        public final String readString() {
            int c = 0;
            try {
                c = read();
            } catch (IOException ex) {
            }
            while (isSpaceChar(c)) {
                try {
                    c = read();
                } catch (IOException ex) {
                }
            }
            StringBuilder res = new StringBuilder();
            do {
                res.append((char) c);
                try {
                    c = read();
                } catch (IOException ex) {
                }
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}

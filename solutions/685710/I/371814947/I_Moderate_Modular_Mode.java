import java.io.*;
import java.util.*;

public class I_Moderate_Modular_Mode {
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    return null;
                }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while(t-- > 0) {
            long x = fs.nextLong();
            long y = fs.nextLong();
            //I had a somewhat working version that divded the problem into cases and tried to adjust the value based on the 
            //answer to those cases but it kept not working for certain test cases and was very slow, so I used AI and found the actual solution was 
            //much simpler than I had thought. Still find myself really struggling when it comes to these mod questions. Getting better though. 
            long n;
            if (x > y) {
                n = x + y;
            } else {
                long r = y % x;
                n = y - r / 2;
            }
            out.append(n + "\n");
        }

        System.out.print(out);
    }
}
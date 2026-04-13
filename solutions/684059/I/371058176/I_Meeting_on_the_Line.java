import java.io.*;
import java.util.*;

public class I_Meeting_on_the_Line {
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
            int n = fs.nextInt();
            int[] x = new int[n];
            int[] time = new int[n];
            for(int i = 0; i < n; i++) { x[i] = fs.nextInt(); }
            for(int i = 0; i < n; i++) { time[i] = fs.nextInt(); }
            if(n == 1) {
                out.append(x[0]).append("\n");
                continue;
            }
            //One small logic hint from AI, all code is mine
            int largestLeft = Integer.MIN_VALUE;
            int largestRight = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                int val1 = time[i] + x[i];
                int val2 = time[i] - x[i];
                largestLeft = Math.max(largestLeft, val1);
                largestRight = Math.max(largestRight, val2);
            }
            out.append(((largestLeft - largestRight) / 2.0)).append("\n");
        }

        System.out.print(out);
    }
}
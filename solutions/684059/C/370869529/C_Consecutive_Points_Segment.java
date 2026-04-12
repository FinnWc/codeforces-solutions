import java.io.*;
import java.util.*;

public class C_Consecutive_Points_Segment {
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
            int[] a = new int[n];
            for(int i = 0; i < n; i++) { a[i] = fs.nextInt(); }
            if(n == 1) {
                out.append("YES\n");
                continue;
            }
            long lowerBound = a[0] -1;
            long upperBound = a[0] + 1;
            for(int i = 1; i < n; i++) {
                //one AI hint
                long left = a[i] - i - 1;
                long right = a[i] - i + 1;
                lowerBound = Math.max(lowerBound, left);
                upperBound = Math.min(right, upperBound);
            }
            if(lowerBound <= upperBound) {
                out.append("YES\n");
            } else {
                out.append("NO\n");
            }
        }

        System.out.print(out);
    }
}

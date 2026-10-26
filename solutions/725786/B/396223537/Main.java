
import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();
            long[] a = new long[n];

            //this was one of the first DP problems I've done in a while and found myself really struggling to find the 
            //recurrance. I decided to walk through a solution with AI in order to remind myself how to solve these kinds of problems
            //learned a lot

            long suffix = 0;

            for (int i = 0; i < n; i++) {
                a[i] = fs.nextLong();
                if (i > 0) suffix += a[i];
            }

            // Case 1: Leave the first child
            long ans = -suffix;
            long prefix = 0;

            // Try leaving each other child
            for (int k = 1; k < n; k++) {
                if (k > 1) {
                    prefix += Math.abs(a[k - 1]);
                }

                suffix -= a[k];

                long current = a[0] + prefix - suffix;
                ans = Math.max(ans, current);
            }

            out.append(ans).append('\n');
        }

        System.out.print(out);
    }
}

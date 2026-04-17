import java.io.*;
import java.util.*;

public class C_Assembly_via_Remainders {
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
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n-1; i++) {
                a[i] = fs.nextInt();
                max = Math.max(max, a[i]);
            }
            int[] ans = new int[n];
            ans[0] = ++max;
            for(int i = 1; i < n; i++) {
                ans[i] = ans[i-1] + a[i-1];
            }
            for(int val : ans) {
                out.append(val + " ");
            }
            out.append("\n");
        }

        System.out.print(out);
    }
}
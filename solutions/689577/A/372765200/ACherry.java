import java.io.*;
import java.util.*;

public class ACherry {
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
            long maxVal = Long.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            for(int i = 0; i < n-1; i++) {
                maxVal = Math.max(1L * a[i] * a[i+1],maxVal);
            }
            out.append(maxVal).append("\n");
        }

        System.out.print(out);
    }
}
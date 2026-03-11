import java.io.*;
import java.util.*;

public class A_Password {
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
            int digits = 10-n;
            int[] a = new int[n];
            for(int i = 0; i < n; i++) { a[i] = fs.nextInt(); }
            int ans = 6 * (fact(digits) / (2 * fact(digits - 2)));
            out.append(ans).append('\n');
        }

        System.out.print(out);
    }
    public static int fact(int i) {
        int ans = 1;
        for(int j = 2; j <= i; j++) {
            ans *= j;
        }
        return ans;
    }
}
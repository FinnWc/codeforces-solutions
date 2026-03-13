import java.io.*;
import java.util.*;

public class D_Emordnilap {
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

        final int MOD = (int) Math.pow(10,9) + 7;
        int t = fs.nextInt();
        long[] factorial = new long[100001];
        factorial[0] = 1;
        for(int i = 1; i < factorial.length; i++) {
            factorial[i] = factorial[i-1] * i % MOD;
        }
        while(t-- > 0) {
            int n = fs.nextInt();
            //took me a long time to realize this was the best option. kept trying an approach that was way too slowj
            //got this after one hint from AI
            long ans = factorial[n] * n % MOD * (n-1) % MOD;
            out.append(ans).append("\n");
        }

        System.out.print(out);
    }
}
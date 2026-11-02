import java.io.*;
import java.util.*;

public class DMathDivision {
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
            String a = fs.next();
            //tried for around an hour to implement DP on this, I understood the ceil and floor implications 
            //but didn't realize that you could just solve it using the carry bit and without having to interact 
            //with the long string. AI help:
            int mod = 1000000007;
            long p = 0;
            long inv2 = 500000004L;

            for (int i = n - 1; i >= 1; i--) {
                if (a.charAt(i) == '0') {
                    p = (p * inv2) % mod;
                } else {
                    p = ((p + 1) * inv2) % mod;
                }
            }

            long ans = (n - 1 + p) % mod;
            out.append(ans).append("\n");

        }

        System.out.print(out);
    }
}
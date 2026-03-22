import java.io.*;
import java.util.*;

public class O_Card_Game {
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

    static final long MOD = 998244353L;

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int MAX = 60;

        long[][] C = new long[MAX + 1][MAX + 1];

        //was quite confused on this problem but realized it was a pascals triangle type problem. completely forgot how those
        //worked so followed step by step with AI. I understand this all now.
        for (int i = 0; i <= MAX; i++) {
            C[i][0] = 1;
            C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }
        long[] alex = new long[MAX + 1];
        long[] boris = new long[MAX + 1];
        long[] draw = new long[MAX + 1];
        alex[2] = 1;
        boris[2] = 0;
        draw[2] = 1;
        for (int n = 4; n <= MAX; n += 2) {
            int k = n / 2;

            alex[n] = (C[n - 1][k - 1] + boris[n - 2]) % MOD;
            boris[n] = (C[n - 2][k - 2] + alex[n - 2]) % MOD;
            draw[n] = 1;
        }
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            out.append(alex[n]).append(" ")
               .append(boris[n]).append(" ")
               .append(draw[n]).append("\n");
        }
        System.out.print(out);
    }
}
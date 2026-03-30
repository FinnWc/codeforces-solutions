import java.io.*;
import java.util.*;

public class L_Bookshelves {
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

        int n = fs.nextInt();
        int k = fs.nextInt();
        long answer = 0;
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = fs.nextLong();

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + a[i];
        }

        //knew this was a prefix problem but had never done a problem with a bitmask before so it didn't come into my mind
        //kept trying to find some sort of greedy/dp solution here but AI helped me eventually realize how to use the approach below:
        for (int bit = 60; bit >= 0; bit--) {
            long testMask = answer | (1L << bit);

            boolean[][] dp = new boolean[n + 1][k + 1];
            dp[0][0] = true;

            for (int i = 1; i <= n; i++) {
                for (int shelves = 1; shelves <= k; shelves++) {
                    for (int j = 0; j < i; j++) {
                        long segmentSum = prefix[i] - prefix[j];

                        if (dp[j][shelves - 1] && (segmentSum & testMask) == testMask) {
                            dp[i][shelves] = true;
                            break;
                        }
                    }
                }
            }

            if (dp[n][k]) answer = testMask;
        }
        out.append(answer).append("\n");
        System.out.print(out);
    }
}
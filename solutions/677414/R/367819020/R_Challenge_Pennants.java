import java.io.*;
import java.util.*;

public class R_Challenge_Pennants {
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
        out.append(choose(t+4,5) * choose(t+2,3));
        System.out.print(out);
    }

    //copied this code from my answer in N
    static long choose(int n, int k) {
        if (k < 0 || k > n) return 0;
        if (k > n - k) k = n - k;

        long ans = 1;
        for (int i = 1; i <= k; i++) {
            ans = ans * (n - k + i) / i;
        }
        return ans;
    }
}
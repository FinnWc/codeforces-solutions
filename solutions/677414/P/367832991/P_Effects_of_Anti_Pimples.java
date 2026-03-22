import java.io.*;
import java.util.*;

public class P_Effects_of_Anti_Pimples {
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

        int n = fs.nextInt();
        int[] a = new int[n+1];
        for(int i = 1; i <= n; i++) { a[i] = fs.nextInt(); }

        int[] max = new int[n+1];
        for(int i = 1; i <= n; i++) {
            int highest = 0;
            for(int j = i; j <= n; j += i) {
                if(a[j] > highest) {
                    highest = a[j];
                }
                max[i] = highest;
            }
        }

        //help from AI for the following code, it makes sense to me now:
        int[] vals = new int[n];
        for(int i = 1; i <= n; i++) {
            vals[i-1] = max[i];
        }
        Arrays.sort(vals);
        long[] powers = new long[n];
        powers[0] = 1;
        for(int i = 1; i < n; i++) {
            powers[i] = (powers[i-1] * 2) % MOD;
        }
        long returnVal = 0;
        for(int i = 0; i < n; i++) {
            returnVal = (returnVal + vals[i] * powers[i]) % MOD;
        }
        out.append(returnVal).append("\n");
        System.out.print(out);
    }
}
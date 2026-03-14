import java.io.*;
import java.util.*;

public class H_Binomial_Coefficients_Kind_Of {
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
        int[] n = new int[t];
        int[] k = new int[t];
        int maxKVal = Integer.MIN_VALUE;
        for(int i = 0; i < t; i++) { n[i] = fs.nextInt(); }
        for(int i = 0; i < t; i++) { 
            k[i] = fs.nextInt(); 
            maxKVal = Math.max(maxKVal, k[i]);
        }
        final int MOD = (int) Math.pow(10,9) + 7;
        //came to the realization that it is always 2^k by myself but struggled to find a way to 
        //compute the total without losing information or failing for large k. I used: (int)Math.pow(2,k[i]) % MOD, 
        //which obviously doesn't work for large k. AI helped me realize that if I precompute the values of 2^whatever the max
        //k value is (mod MOD), information isn't lost and it works for large k. 
        long[] powers = new long[maxKVal+1];
        powers[0] = 1;
        for(int i = 1; i <= maxKVal; i++) {
            powers[i] = powers[i-1] * 2 % MOD;
        }
        for(int i = 0; i < t; i++) {
            out.append(powers[k[i]]).append("\n");
        }

        System.out.print(out);
    }
}
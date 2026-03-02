import java.io.*;
import java.util.*;

public class G_Bad_Prices {
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

            for(int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            //after trying a few different approaches, a hint that AI helped me with was iterating right to left
            int badPrices = 0;
            int minVal = Integer.MAX_VALUE;
            for(int i = n-1; i >= 0; i--) {
                if(minVal < a[i]) {
                    badPrices++;
                }
                if(a[i] < minVal) { 
                    minVal = a[i];
                }
            }
            out.append(badPrices).append("\n");
        }
        System.out.print(out);
    }
}
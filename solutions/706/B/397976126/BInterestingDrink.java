import java.io.*;
import java.util.*;

public class BInterestingDrink {
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
        int[] x = new int[n];
        for(int i = 0; i < n; i++) {
            x[i] = fs.nextInt();
        }
        int q = fs.nextInt();
        int[] m = new int[q];
        for(int i = 0; i < q; i++) {
            m[i] = fs.nextInt();
        }
        Arrays.sort(x);
        for(int i = 0; i < q; i++) {
            int low = 0;
            int hi = n-1;
            int target = m[i];
            while(low <= hi) {
                int mid = low + (hi - low) / 2;
                if(x[mid] <= target) {
                    low = mid+1;
                } else {
                    hi = mid - 1;
                }
            }
            out.append(low).append("\n");
        }

        System.out.print(out);
    }
}

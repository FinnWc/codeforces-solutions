import java.io.*;
import java.util.*;

public class H_Very_Different_Array {
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
            int m = fs.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for(int i = 0; i < n; i++) { a[i] = fs.nextInt(); }
            for(int i = 0; i < m; i++) { b[i] = fs.nextInt(); }
            Arrays.sort(b);
            Arrays.sort(a);
            long highest = 0;
            //as you can see from my previous attempt, I wasn't quite understanding how to do this problem
            //AI gave hint of using prefix sums
            long[] prefixLargest = new long[n+1];
            long[] prefixSmallest = new long[n+1];
            for(int i = 1; i <= n; i++) {
                int index = i-1;
                prefixLargest[i] = prefixLargest[i-1] + Math.abs(a[index]-b[m-i]);
            }
            for(int i = 1; i <= n; i++) {
                int index = i-1;
                prefixSmallest[i] = prefixSmallest[i-1] + Math.abs(a[n-i]-b[index]);
            }
            for(int i = 0; i <= n; i++) {
                int index = n-i;
                long sum = prefixLargest[index] + prefixSmallest[i];
                if(highest<sum) {
                    highest = sum;
                }
            }
            out.append(highest).append("\n");
            
        }

        System.out.print(out);
    }
}
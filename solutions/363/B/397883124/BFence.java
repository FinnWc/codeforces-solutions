import java.io.*;
import java.util.*;

public class BFence {
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
        int[] a = new int[n];
        long minSum = Integer.MAX_VALUE;
        int index = 0;
        int tempSum = 0;
        for(int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
            if(i < k) {
                tempSum += a[i];
            }
        }
        minSum = Math.min(minSum, tempSum);
        for(int i = 1; i <= n-k; i++) {
            tempSum -= a[i-1];
            tempSum += a[i+k-1];
            if(tempSum < minSum) {
                minSum = tempSum;
                index = i;
            }
        }

        out.append(index+1);
        System.out.print(out);
    }
}
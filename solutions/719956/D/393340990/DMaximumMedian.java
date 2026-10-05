import java.io.*;
import java.util.*;

public class DMaximumMedian {
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
        //was having lots of trouble figuring this one out. Watched a video on it and worked through it with AI as well.
        int n = fs.nextInt();
        long k = fs.nextLong();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = fs.nextInt();
        }
        Arrays.sort(x);
        int mid = n / 2;
        long current = x[mid];
        int count = 1;
        for (int i = mid + 1; i < n; i++) {
            long gap = x[i] - current;
            long cost = gap * count;
            if (cost <= k) {
                k -= cost;
                current = x[i];
                count++;
            } else {
                current += k / count;
                k = 0;
                break;
            }
        }
        if (k > 0) {
            current += k / count;
        }
        System.out.println(current);
    }
}
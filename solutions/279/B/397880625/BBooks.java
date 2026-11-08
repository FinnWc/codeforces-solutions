import java.io.*;
import java.util.*;

public class BBooks {
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
        int t = fs.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }
        long runningSum = 0;
        int maxNumBooks = 0;
        int left = 0;
        int right = 0;
        runningSum += a[left];
        while(n > right && left <= right) {
            if(runningSum <= t) {
                maxNumBooks = Math.max(maxNumBooks, right-left+1);
                if(++right < n) {
                    runningSum += a[right];
                } else {
                    break;
                }
            } else {
                runningSum -= a[left++];
                if(left > right) {
                    right++;
                    if(right < n) {
                        runningSum += a[right];
                    }
                }
            }
        }
        out.append(maxNumBooks);
        System.out.print(out);
    }
}
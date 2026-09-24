import java.io.*;
import java.util.*;

public class DBooks {
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

        //had some bugs in my original, realized what I messed up after asking AI
        int n = fs.nextInt();
        int t = fs.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = fs.nextInt();    
        }
        int best = 0;
        int left = 0;
        int right;
        int sum = 0;
        for(right = 0; right < n; right++) {
            sum += a[right];
            while(sum > t) {
                sum -= a[left++];
            }
            best = Math.max(best, right-left + 1);
        }
        out.append(best);

        System.out.print(out);
    }
}
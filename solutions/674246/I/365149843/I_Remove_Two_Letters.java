import java.io.*;
import java.util.*;

public class I_Remove_Two_Letters {
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
    }

    static long subHash(long[] pref, long[] pow, int l, int r) {
        return pref[r] - pref[l] * pow[r - l];
    }
    //as you can see in my previous attempts, all the solutions I knew how to create were in O(n^2) memory, I slowly walked
    //through this solution with AI and now learned and understand a bunch more about 64-bit rolling hash and when to use it. 
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            long base = 911382323L ^ System.nanoTime();
            long[] pref = new long[n + 1];
            long[] pow = new long[n + 1];
            pow[0] = 1;
            for (int i = 0; i < n; i++) {
                int x = s.charAt(i) - 'a' + 1;
                pow[i + 1] = pow[i] * base;
                pref[i + 1] = pref[i] * base + x;
            }
            HashSet<Long> set = new HashSet<>(n * 2);
            for (int i = 0; i < n - 1; i++) {
                int lenRight = n - (i + 2);
                long left = subHash(pref, pow, 0, i);
                long right = subHash(pref, pow, i + 2, n);
                long h = left * pow[lenRight] + right;
                set.add(h);
            }
            out.append(set.size()).append('\n');
        }
        System.out.print(out);
    }
}
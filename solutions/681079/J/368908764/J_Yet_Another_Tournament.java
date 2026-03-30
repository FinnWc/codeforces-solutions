import java.io.*;
import java.util.*;

public class J_Yet_Another_Tournament {
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

     static class Pair {
        int val, idx;
        Pair(int v, int i) {
            val = v;
            idx = i;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
        //I kept trying to implement a greedy solution to this problem with no luck. Had to have AI walk me through the solution. 
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long m = fs.nextInt();

            int[] a = new int[n + 1];
            Pair[] arr = new Pair[n];
            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextInt();
                arr[i - 1] = new Pair(a[i], i);
            }
            Arrays.sort(arr, (x, y) -> x.val - y.val);
            long[] pref = new long[n + 1];
            int[] pos = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                pref[i] = pref[i - 1] + arr[i - 1].val;
                pos[arr[i - 1].idx] = i;
            }
            int ans = n + 1;
            for (int k = 0; k <= n; k++) {
                if (pref[k] <= m) ans = Math.min(ans, n - k + 1);
                if (k >= 1 && k < n) {
                    int x = k + 1;
                    long need = a[x];
                    int take = k - 1;
                    if (take > 0) {
                        if (pos[x] > take) {
                            need += pref[take];
                        } else {
                            need += pref[take + 1] - a[x];
                        }
                    }
                    if (need <= m) ans = Math.min(ans, n - k);
                }
            }
            out.append(ans).append('\n');
        }

        System.out.print(out);
    }
}
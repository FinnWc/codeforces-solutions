import java.io.*;
import java.util.*;

public class K_Reorder_the_Array {
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
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }
        Arrays.sort(a);
        int q = 0;
        int p = 0;
        int total = 0;
        while(q < n && p < n) {
            while(p < n-1 && a[q] >= a[p]) {
                p++;
            }
            if(p == n) {
                break;
            } else if(a[q] == a[p]) {
                break;
            }
            p++;
            q++;
            total++;
        }
        out.append(total).append("\n");
        System.out.print(out);
    }
}
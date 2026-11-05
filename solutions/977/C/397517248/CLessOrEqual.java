import java.io.*;
import java.util.*;

public class CLessOrEqual {
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
        for(int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }
        Arrays.sort(a);
        int x=-1;

        if(k == 0) {
            if(a[0] > 1) {
                x = 1;
            }
        } else {
            int kVal = a[k-1];
            if(k == n || kVal < a[k]) {
                x = kVal;
            }
        }
        
        out.append(x);

        System.out.print(out);
    }
}
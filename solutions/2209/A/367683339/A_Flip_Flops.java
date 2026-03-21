import java.io.*;
import java.util.*;

public class A_Flip_Flops {
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
            int c = fs.nextInt();
            int k = fs.nextInt();
            long[] a = new long[n];
            for(int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            Arrays.sort(a);
            long total = c;
            for(int i = 0; i < n; i++) {
                if(a[i] > total) {
                    break;
                } else if(a[i] <= total){
                    if(k < total - a[i]) {
                        total += a[i] + k;
                        k = 0;
                    } else {
                        k -= total-a[i];
                        total *= 2;
                    }
                }
            }
            out.append(total).append("\n");
        }
        System.out.print(out);
    }
}
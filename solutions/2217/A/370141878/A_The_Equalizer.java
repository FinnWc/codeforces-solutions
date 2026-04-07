import java.io.*;
import java.util.*;

public class A_The_Equalizer {
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
            int k = fs.nextInt();
            int[] a = new int[n];
            int sum = 0;
            for(int i = 0; i < n; i++) { 
                a[i] = fs.nextInt(); 
                sum += a[i];
            }
            if(sum % 2 == 1) {
                out.append("YES\n");
            } else if(sum % 2 == 0 && (k * n) % 2 == 0) {
                out.append("YES\n");
            } else {
                out.append("NO\n");
            }
        }
        System.out.print(out);
    }
}
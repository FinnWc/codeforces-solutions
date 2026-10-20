import java.io.*;
import java.util.*;

public class ANeedMoreArrays {
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
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            int temp = 0;
            if(n == 1) {
                out.append(1).append("\n");
                continue;
            }
            long count = 0;
            for(int i = 1; i < n; i++) {
                if(a[i] > a[temp] + 1) {
                    count++;
                    temp = i;
                }
            }
            out.append(count+1).append("\n");
        }

        System.out.print(out);
    }
}
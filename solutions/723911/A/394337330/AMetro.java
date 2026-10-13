import java.io.*;
import java.util.*;

public class AMetro {
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
        int s = fs.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }
        for(int i = 0; i < n; i++) {
            b[i] = fs.nextInt();
        }
        boolean flag = false;
        for(int i = s; i < n; i++) {
            if(a[i] == 1 && b[i] == 1) {
                flag = true;
            }
        }
        if((a[s-1] == 0 && b[s-1] == 0) || (a[0] == 0 && s > 0) || (a[s-1] == 0 && !flag)) {
            out.append("NO");
        } else {
            out.append("YES");
        }

        System.out.print(out);
    }
}

import java.io.*;
import java.util.*;
//this was my answer in class for this problem
public class A_JOE_is_on_TV {
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
        double nDouble = n;
        double ans = 0;
        for(int i = n; i > 0; i--) {
            ans += 1/nDouble;
            nDouble--;
        }
        out.append(ans);
        System.out.print(out);
    }
}
import java.io.*;
import java.util.*;

public class D_Mainak_and_Interesting_Sequence {
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
            //really still struggle with the xor problems. tried my best to figure this one out but couldn't quite get it.
            //ended up working through it with AI. Understand it now
            int n = fs.nextInt();
            int m = fs.nextInt();
            if (m < n) {
                out.append("No\n");
            } else if (n % 2 == 0 && m % 2 == 1) {
                out.append("No\n");
            } else {
                out.append("Yes\n");
                if (n % 2 == 1) {
                    for (int i = 0; i < n - 1; i++) {
                        out.append("1 ");
                    }
                    out.append(m - (n - 1)).append('\n');
                } else {
                    for (int i = 0; i < n - 2; i++) {
                        out.append("1 ");
                    }
                    int last = (m - (n - 2)) / 2;
                    out.append(last).append(" ").append(last).append('\n');
                }
            }
        }

        System.out.print(out);
    }
}
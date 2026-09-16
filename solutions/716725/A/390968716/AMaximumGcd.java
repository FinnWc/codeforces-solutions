import java.io.*;
import java.util.*;

public class AMaximumGcd {
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
            if(n % 2 == 0) {
                out.append(n/2).append("\n");
                continue;
            } else {
                out.append((n-1)/2).append("\n");
            }
        }

        System.out.print(out);
    }

    public static int gcd(int a, int b) {
        if(b == 0) {
            return Math.abs(a);
        }
        return gcd(b,a%b);
    }
}
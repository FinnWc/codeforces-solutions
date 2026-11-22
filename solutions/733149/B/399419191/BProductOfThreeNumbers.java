import java.io.*;
import java.util.*;

public class BProductOfThreeNumbers {
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

        //one AI hint helped me realize I wasn't checking if a != c
        int t = fs.nextInt();
        while(t-- > 0) {
            int n = fs.nextInt();
            int a = -1;
            for(int i = 2; i <= Math.sqrt(n); i++) {
                if(n % i == 0) {
                    a = i;
                    break;
                }
            }
            if(a == -1) {
                out.append("NO\n");
                continue;
            }
            int rem = n/a;
            int b = -1;
            for(int i = 2; i <= Math.sqrt(rem); i++) {
                if(rem % i == 0 && rem / i != a && i != a && rem / i != i) {
                    b = rem / i;
                }
            }
            if(b == -1 || (a < 2 || b < 2 || n/(a*b) < 2)) {
                out.append("NO\n");
                continue;
            }
            out.append("YES\n").append(a + " " + b + " " + (n/(a*b))).append("\n");
        }
        System.out.print(out);
    }
}
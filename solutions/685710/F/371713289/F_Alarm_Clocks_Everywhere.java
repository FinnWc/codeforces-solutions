import java.io.*;
import java.util.*;

public class F_Alarm_Clocks_Everywhere {
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

    static long gcd(long a, long b) {
        if(b == 0)
            return a;
        return gcd(b,a%b);
    }

    static long arrGcd(long[] arr) {
        long ans = arr[0];
        for(long val: arr) {
            ans = gcd(ans, val);
        }
        return ans;
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int n = fs.nextInt();
        int m = fs.nextInt();
        long[] x = new long[n];
        long[] p = new long[m];
        for(int i = 0; i < n; i++) { x[i] = fs.nextLong(); }
        for(int i = 0; i < m; i++) { p[i] = fs.nextLong(); }

        //didn't realize I should be using longs, AI helped me realize that
        long[] gcdarr = new long[n-1];
        for(int i = 1; i < n; i++) {
            gcdarr[i-1] = x[i] - x[0];
        }
        long ans = arrGcd(gcdarr);
        int index = -1;
        for(int i = 0; i < m; i++) {
            if(ans % p[i] == 0) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            out.append("NO");
        } else {
            out.append("YES\n" + x[0] + " " + (index+1));
        }

        System.out.print(out);
    }
}
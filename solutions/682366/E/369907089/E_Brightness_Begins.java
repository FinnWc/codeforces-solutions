import java.io.*;
import java.util.*;

public class E_Brightness_Begins {
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

    //helped by google AI when I was looking for ways to fix floating point errors at the top of the long range for Math.sqrt
    static long int_sqrt(long n) {
        long r = (long)Math.sqrt(n);
        while ((r + 1) <= n / (r + 1)) r++;
        while (r > n / r) r--;
        return r;
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while(t-- > 0) {
            long k = fs.nextLong();
            long q = 1;
            long p = 2 * k; 
            //knew this was binary search but couldn't quite figure out the fact that perfect squares are the only number that have 
            //odd number of divisors. AI helped me figure that out along with a couple stepping stones to get me to figure out the logic. I wrote the code after that help
            while(q < p) {
                long mid = q + (p - q) / 2;
                long numOn = mid - (long) int_sqrt(mid);
                if(numOn >= k) {
                    p = mid;
                } else {
                    q = mid+1;
                }
            }
            out.append(q + "\n");
        }

        System.out.print(out);
    }
}
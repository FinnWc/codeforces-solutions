import java.io.*;
import java.util.*;

public class C_Longest_Divisors_Interval {
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

    //wrote gcd and lcm with help from AI. forgot how to do that from scratch
    static long gcd(long a, long b) {
        while(b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static long lcm(long a, long b) {
        return a / gcd(a,b) * b;
    }
 
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while(t-- > 0) {
            long n = fs.nextLong();
            int ans = 0;
            long curLcm = 1;
            //figured this out after a couple hints from AI
            for(long i = 1; ; i++) {
                curLcm = lcm(curLcm, i);
                if(curLcm > n || n % curLcm != 0) {
                    break;
                }
                ans = (int)i;
            }
            out.append(ans).append("\n");
        }

        System.out.print(out);
    }
}
import java.io.*;
import java.util.*;

public class I_Earning_on_Bets {
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
        if(b == 0) {
            return a;
        } else {
            return gcd(b,a%b);
        }
    }

    static long lcm(long a, long b) {
        if(a == 0 || b == 0) {
            return 0;
        } else {
            return a / gcd(a,b) * b;
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while(t-- > 0) {
            //solved this problem during class with a couple partners. I didn't end up finishing the code
            //during the live contest but had the logic figured out. 
            int n = fs.nextInt();
            int[] k = new int[n];
            long sum = 0;
            for(int i = 0; i < n; i++) { k[i] = fs.nextInt(); }
            long arrayLcm = k[0];
            for(int i = 1; i < n; i++) {
                arrayLcm = lcm(arrayLcm, k[i]);
            }
            long[] output = new long[n];
            for(int i = 0; i < n; i++) {
                output[i] = arrayLcm / k[i];
                sum += output[i];
            }
            if(arrayLcm <= sum) {
                out.append("-1\n");
            } else {
                for(int i = 0; i < n; i++) {
                    out.append(output[i] + " ");
                }
                out.append("\n");
            }
            
        }

        System.out.print(out);
    }
}
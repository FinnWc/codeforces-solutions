import java.io.*;
import java.util.*;

public class ATPrimes {
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
        long[] a = new long[n];
        for(int i = 0; i < n; i++) {
            a[i] = fs.nextLong();
        }
        long temp;
        for(int i = 0; i < n; i++) {
            temp = a[i]; 
            if(temp < 4) {
                out.append("NO\n");
                continue;
            }
            long root = (long) Math.sqrt(temp);
            if(root*root != temp) {
                out.append("NO\n");
                continue;
            }
            //adapted following code from the internet to check whether a number is prime or not
            if(root < 2) {
                out.append("NO\n");
                continue;
            }
            if(root <= 3) {
                out.append("YES\n");
                continue;
            }
            if(root % 3 == 0 || root % 2 == 0) {
                out.append("NO\n");
                continue;
            }
            boolean isPrime = true;
            for(int j = 5; j * j <= root; j+=6) {
                if(root % j == 0 || root % (j+2) == 0) {
                    out.append("NO\n");
                    isPrime = false;
                    break;
                }
            }
            if(!isPrime) {
                continue;
            }
            out.append("YES").append("\n");
            continue;
        }
        System.out.print(out);
    }
}
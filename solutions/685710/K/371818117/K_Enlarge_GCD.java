import java.io.*;
import java.util.*;

public class K_Enlarge_GCD {
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

    static int gcd(int a, int b) {
        if(b==0)
            return a;
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int n = fs.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }
        int g = a[0];
        for(int v : a) {
            g = gcd(g, v);
        }
        int maxVal = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            a[i] = a[i] / g;
            maxVal = Math.max(maxVal, a[i]);
        }

        //ai showed me how to optimize my earlier code with this precomputed sieve idea, since it was too slow to compute
        //all the prime factors for each value in the normalized array
        int[] smallestPF = new int[maxVal + 1];
        for (int i = 2; i <= maxVal; i++) {
            if (smallestPF[i] == 0) {
                smallestPF[i] = i;
                if ((long) i * i <= maxVal) {
                    for (int j = i * i; j <= maxVal; j += i) {
                        if (smallestPF[j] == 0) {
                            smallestPF[j] = i;
                        }
                    }
                }
            }
        }
        
        int[] freq = new int[maxVal+1];
        for(int i = 0; i < n; i++) {
            while (a[i] > 1) {
                int p = smallestPF[a[i]];
                freq[p]++;
                while (a[i] % p == 0) {
                    a[i] /= p;
                }
            }
        }
        int maxFreq = 0;
        for(int i = 2; i <= maxVal; i++) {
            maxFreq = Math.max(maxFreq, freq[i]);
        }
        if(maxFreq == 0) {
            out.append(-1);
        } else {
            out.append(n-maxFreq);
        }
        System.out.print(out);
    }
}
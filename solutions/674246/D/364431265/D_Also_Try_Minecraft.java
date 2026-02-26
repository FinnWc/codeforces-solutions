import java.io.*;
import java.util.*;

public class D_Also_Try_Minecraft {
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
        int m = fs.nextInt();
        int[] a = new int[n];
        long[] sumDamageForward = new long[n+1];
        long[] sumDamageBackwords = new long[n];
        sumDamageForward[0] = 0;
        sumDamageBackwords[n-1] = 0;
        for(int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
            
        }
        for(int i = 0; i < n-1; i++) {
            if(a[i] > a[i+1]) {
                sumDamageForward[i+1] = a[i] - a[i+1] + sumDamageForward[i];
            } else {
                sumDamageForward[i+1] = sumDamageForward[i];
            }
        }
        for(int i = n-1; i > 0; i--) {
            if(a[i] > a[i-1]) {
                sumDamageBackwords[i-1] = a[i] - a[i-1] + sumDamageBackwords[i];
            } else {
                sumDamageBackwords[i-1] = sumDamageBackwords[i];
            }
        }
        for(int i = 0; i < m; i++) {
            int s = fs.nextInt()-1;
            int t = fs.nextInt()-1;
            if(s<t) {
                out.append(sumDamageForward[t] - sumDamageForward[s]).append("\n");
            } else {
                out.append(sumDamageBackwords[t] - sumDamageBackwords[s]).append("\n");
            }
        }
        System.out.print(out);
    }
}
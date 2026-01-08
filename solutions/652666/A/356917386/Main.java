import java.io.*;
import java.util.*;

public class Main {
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
        while(t>0) {
            int n = fs.nextInt();
            if(n%4 != 0) {
                out.append("NO\n");
                t--;
                continue;
            }
            out.append("YES\n");
            int[] a = new int[n];
            long evenSum = 0;
            long oddSum = 0;
            int halfVal = n/2;
            for(int i = 0; i < halfVal; i++) {
                a[i] = 2*(i+1);
                evenSum += a[i];
            }
            for(int i = 0; i < halfVal - 1; i++) {
                a[halfVal+i] = 2*i+1;
                oddSum += a[halfVal+i];
            }
            a[n-1] = (int)(evenSum - oddSum);
            for(int i = 0; i < n; i++) {
            if(i > 0) {
                out.append(' ');
            }
            out.append(a[i]);
        }
            out.append('\n');
            t--;
        }
        

        System.out.print(out);
    }
} 

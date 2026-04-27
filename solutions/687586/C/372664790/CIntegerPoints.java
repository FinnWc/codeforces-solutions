import java.io.*;
import java.util.*;

public class CIntegerPoints {
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
            long[] p = new long[n];
            for(int i = 0; i < n; i++) { p[i] = fs.nextLong(); }
            int m = fs.nextInt();
            long[] q = new long[m];
            for(int i = 0; i < m; i++) { q[i] = fs.nextLong(); }
            long numEvenp = 0;
            long numOddp = 0;
            long numEvenq = 0;
            long numOddq = 0;
            for(int i = 0; i < n; i++) {
                if(p[i] % 2 == 0) {
                    numEvenp++;
                } else {
                    numOddp++;
                }
            }
            for(int i = 0; i < m; i++) {
                if(q[i] % 2 == 0) {
                    numEvenq++;
                } else {
                    numOddq++;
                }
            }
            out.append(((numEvenp * numEvenq)+(numOddp * numOddq))).append("\n");
        }

        System.out.print(out);
    }
}
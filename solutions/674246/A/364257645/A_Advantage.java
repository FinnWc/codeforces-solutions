import java.io.*;
import java.util.*;

public class A_Advantage {
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
            int max = Integer.MIN_VALUE;
            int secondMax = Integer.MIN_VALUE;
            int n = fs.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) { a[i] = fs.nextInt(); }
            int[] sortedA = Arrays.copyOf(a, n);
            Arrays.sort(sortedA);
            max = sortedA[n-1];
            secondMax = sortedA[n-2];
            for(int i = 0; i < n; i++) {
                if(max == a[i]) {
                    out.append(a[i] - secondMax).append(" ");
                } else 
                out.append(a[i] - max).append(" ");
            }
            out.append("\n");
        }
        System.out.print(out);
    }
}
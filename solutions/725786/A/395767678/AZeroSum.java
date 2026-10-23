import java.io.*;
import java.util.*;

public class AZeroSum {
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
            int[] a = new int[n];
            int countNeg = 0;
            int countPos = 0;
            for(int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
                if(a[i] == -1) {
                    countNeg++;
                } else {
                    countPos++;
                }
            }   
            if(n % 2 == 1) {
                out.append("NO").append("\n");
                continue;
            } else if(countNeg % 2 != (n/2) % 2) {
                out.append("NO").append("\n");
                continue;
            } else{
                out.append("YES").append("\n");
            }
        }
        System.out.print(out);
    }
}
import java.io.*;
import java.util.*;

public class CTheofanisNightmare {
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

        //AI Hints lead me to realize that this was a suffix problem. Wrote the rest of the code
        //by myself. 
        int t = fs.nextInt();
        while(t-- > 0) {
            int n = fs.nextInt();
            long[] a = new long[n];
            long[] suffix = new long[n];
            long sum;
            int counter = 1;
            for(int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            suffix[n-1] = a[n-1];
            for(int i = n-2; i >= 0; i--) {
                suffix[i] = suffix[i+1] + a[i];
            }
            sum = suffix[0];
            for(int i = 1; i < n; i++) {
                if(suffix[i] > 0) {
                    sum += suffix[i];
                }
            }
            out.append(sum + "\n");
        } 

        System.out.print(out);
    }
}
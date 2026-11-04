import java.io.*;
import java.util.*;

public class BRhythmicString {
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
            for(int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            int max = 0;
            for(int i = 0; i < n; i++) {
                int temp = 0;
                for(int j = 0; j < n; j++) {
                    if(a[j] % a[i] == 0) {
                        temp++;
                    }
                }
                max = Math.max(max, temp);
            }
            out.append(Math.abs((max-n)) + "\n");
        }

        System.out.print(out);
    }
}
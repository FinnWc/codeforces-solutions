import java.io.*;
import java.util.*;

public class H_Pythagorean_Triples {
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
            long m = (long) Math.sqrt(2L * n - 1);
            //was having some problems with floating point inaccuracies from Math.sqrt. Found this online to correct:
            while ((m + 1) * (m + 1) <= 2L * n - 1) m++;
            while (m * m > 2L * n - 1) m--;
            out.append((m-1)/2).append("\n");
        }

        System.out.print(out);
    }
}
import java.io.*;
import java.util.*;

public class DGracePeriod {
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
        int c = fs.nextInt();
        long g = fs.nextInt();
        int[] t = new int[n];
        for(int i = 0; i < n; i++) {
            t[i] = fs.nextInt();
        }
        long closingTime = c + g;
        long numAccepted = 0;
        long howLate = 0;
        for(int i = 0; i < n; i++) {
            if(t[i] <= closingTime) {
                numAccepted++;
                if(t[i] > c) {
                    howLate += t[i] - c;
                }
            }
        }
        out.append(numAccepted + " " + howLate);
        System.out.print(out);
    }
}
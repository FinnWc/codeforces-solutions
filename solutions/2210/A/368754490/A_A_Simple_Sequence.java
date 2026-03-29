import java.io.*;
import java.util.*;

public class A_A_Simple_Sequence {
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
            if(n == 2) {
                out.append(2 + " " + 1 + "\n");
            } else {
                out.append(n-1 + " " + n + " ");
                for(int i = n-2; i >= 1; i--) {
                    out.append(i+ " ");
                }
                out.append("\n");
            }
        }
        System.out.print(out);
    }
}
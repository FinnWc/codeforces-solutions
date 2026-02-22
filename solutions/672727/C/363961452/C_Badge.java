import java.io.*;
import java.util.*;

public class C_Badge {
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
        int[] p = new int[n];
        for(int i = 0; i < n; i++) { p[i] = fs.nextInt()-1; }
        int[] ans = new int[n];
        //refined some of the logic below with AI, I understand everything and it all makes sense
        for(int startLoc = 0; startLoc < n; startLoc++) {
            boolean[] seen = new boolean[n];
            int cur = startLoc;
            while(!seen[cur]) {
                seen[cur] = true;
                cur = p[cur];
            }
            ans[startLoc] = cur + 1;
            out.append(ans[startLoc] + " ");
        }

        System.out.print(out);
    }
}
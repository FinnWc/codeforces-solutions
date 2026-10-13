import java.io.*;
import java.util.*;

public class ABadge {
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
        int[] p = new int[n+1];
        for(int i = 1; i <= n; i++) {
            p[i] = fs.nextInt();
        }
        boolean[] visited = new boolean[n+1];
        int cur;
        for(int i = 1; i <= n; i++) {
            Arrays.fill(visited, false);
            cur = i;
            while(!visited[cur]) {
                visited[cur] = true;
                cur = p[cur];
            }
            out.append(cur + " ");
        }
        
        System.out.print(out);
    }
}
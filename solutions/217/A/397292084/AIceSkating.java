import java.io.*;
import java.util.*;

public class AIceSkating {
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

    static void dfs(int i, int[] x, int[] y, boolean[] visited) {
        visited[i] = true;
        for(int j = 0; j < x.length; j++) {
            if(!visited[j] && (x[j] == x[i] || y[j] == y[i])) {
                dfs(j, x, y, visited);
            }
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int n = fs.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i = 0; i < n; i++) {
            x[i] = fs.nextInt();
            y[i] = fs.nextInt();
        }
        boolean[] visited = new boolean[n];
        int components = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                components++;
                dfs(i, x, y, visited);
            }
        }
        out.append(components-1);
        System.out.print(out);
    }
}
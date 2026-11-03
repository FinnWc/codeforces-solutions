import java.io.*;
import java.util.*;

public class BBadge {
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

    static int dfs(int student, ArrayList<Integer>[] adj, boolean[] visited) {
        if(visited[student] == true) {
            return student;
        } else {
            visited[student] = true;
            return dfs(adj[student].get(0), adj, visited);
        }
        
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int n = fs.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i <= n; i++) {
            int pointedTo = fs.nextInt();
            adj[i].add(pointedTo);
        }

        for(int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n+1];
            int student = dfs(i, adj, visited);
            out.append(student).append(" ");
        }

        System.out.print(out);
    }
}
import java.io.*;
import java.util.*;

public class AParty {
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

    static int dfs(int employee, ArrayList<Integer>[] adj) {
        int longest = 0;
        for(int neighbor : adj[employee]) {
            int length = dfs(neighbor, adj);
            longest = Math.max(length, longest);
        }
        return 1+longest;
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int n = fs.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++) {
            adj[i] = new ArrayList<>();
        }
        int temp;
        ArrayList<Integer> roots = new ArrayList<>();
        for(int i = 1; i < n+1; i++) {
            temp = fs.nextInt();
            if(temp == -1) {
                roots.add(i);
            } else {
                adj[temp].add(i);
            }
        }

        int longest = 0;
        for(int i = 0; i < roots.size(); i++) {
            temp = dfs(roots.get(i), adj);
            longest = Math.max(longest, temp);
        }

        out.append(longest);
        System.out.print(out);
    }
}
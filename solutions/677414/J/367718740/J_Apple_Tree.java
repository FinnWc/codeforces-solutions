import java.io.*;
import java.util.*;

public class J_Apple_Tree {
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

    //was very close to getting this dfs to work by myself but kept running into some weird bugs. Ended up getting some help from 
    //ai to actually get the method working but this definatily made a lot more sense to me than it did when we covered graphs a few weeks ago. Learning! 
    static long[] leafCount;
    static void dfs(int u, int parent, ArrayList<Integer>[] adj) {
        boolean isLeaf = true;
        leafCount[u] = 0;
        for(int v : adj[u]) {
            if(v == parent) {
                continue;
            }
            isLeaf = false;
            dfs(v,u,adj);
            leafCount[u] += leafCount[v];
        }
        if(isLeaf) {
            leafCount[u] += 1;
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while(t-- > 0) {
            int n = fs.nextInt();
            int[] u = new int[n-1];
            int[] v = new int[n-1];
            for(int i = 0; i < n-1; i++) {
                u[i] = fs.nextInt();
                v[i] = fs.nextInt();
            }
            int q = fs.nextInt();
            int[] x = new int[q];
            int[] y = new int[q];
            for(int i = 0; i < q; i++) {
                x[i] = fs.nextInt();
                y[i] = fs.nextInt();
            }
            ArrayList<Integer>[] adj = new ArrayList[n+1];
            for(int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }
            for(int i = 0; i < n-1; i++) {
                adj[u[i]].add(v[i]);
                adj[v[i]].add(u[i]);
            }
            leafCount = new long[n+1];
            dfs(1,0,adj);
            for(int i = 0; i < q; i++) {
                out.append(leafCount[x[i]] * leafCount[y[i]]).append("\n");
            }
        }

        System.out.print(out);
    }
}
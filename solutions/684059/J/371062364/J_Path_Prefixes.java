import java.io.*;
import java.util.*;

public class J_Path_Prefixes {
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
    
    //I walked through most of this code with AI. I came up with the actual idea of using DFS and then binary searching
    //to find the best value of r, but was more complicated than most code I've written in java so far so had some AI 
    //help getting the right syntax and knowing which classes to make
    static class Edge {
        int to;
        long a,b;
        Edge(int to,long a, long b) {
            this.to = to;
            this.a = a;
            this.b = b;
        }
    }

    static ArrayList<Edge>[] g;
    static ArrayList<Long> pathRed;
    static int[] ans;

    static int upperBound(ArrayList<Long> arr, long target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    static void dfs(int u, long blueSum) {
        for (Edge e : g[u]) {
            long newBlue = blueSum + e.a;
            long newRed;
            if (pathRed.isEmpty()) newRed = e.b;
            else newRed = pathRed.get(pathRed.size() - 1) + e.b;
            pathRed.add(newRed);
            ans[e.to] = upperBound(pathRed, newBlue);
            dfs(e.to, newBlue);
            pathRed.remove(pathRed.size() - 1);
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while(t-- > 0) {
            int n = fs.nextInt();
            g = new ArrayList[n+1];
            for(int i = 1; i <= n; i++) {g[i] = new ArrayList<>(); }
            
            for (int j = 2; j <= n; j++) {
                int p = fs.nextInt();
                long a = fs.nextLong();
                long b = fs.nextLong();
                g[p].add(new Edge(j, a, b));
            }
            ans = new int[n + 1];
            pathRed = new ArrayList<>();
            dfs(1, 0L);
            for (int i = 2; i <= n; i++) {
                out.append(ans[i]).append(" ");
            }
            out.append("\n");
        }
        System.out.print(out);
    }
}

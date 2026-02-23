import java.io.*;
import java.util.*;

public class F_White_Black_Balanced_Subtrees {
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

    //I haven't done a real adjacency list/graph problem in quite some time so I had AI slowly walk me through
    //each step of writing the DFS to ensure I knew what I was doing for the next one which I'll attempt first with no help. 
    //I fully understand everything here and get how to implement it in the future.
    static ArrayList<Integer>[] children;
    static char[] color;
    static int balancedCount;
    static int dfs(int u) {
        int sum;
        if(color[u] == 'W') {
            sum = 1;
        } else {
            sum = -1;
        }
        for(int v : children[u]) {
            sum += dfs(v);
        }
        if(sum == 0) {
            balancedCount++;
        }
        return sum;
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while(t-- > 0) {
            int n = fs.nextInt();
            children = new ArrayList[n];
            for(int i = 0; i < n; i++) {
                children[i] = new ArrayList<>();
            }
            for(int i = 1; i < n; i++) {
                children[fs.nextInt()-1].add(i);
            }
            String colorString = fs.next();
            color = colorString.toCharArray();
            balancedCount = 0;
            dfs(0);
            out.append(balancedCount + "\n");
        }

        System.out.print(out);
    }
}
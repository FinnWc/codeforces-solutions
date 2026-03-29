import java.io.*;
import java.util.*;

public class F_Little_Alawn_s_Puzzle {
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

    static final long MOD = (long) Math.pow(10,9) + 7;
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while(t-- > 0) {
            int n = fs.nextInt();
            int[] top = new int[n+1];
            int[] bottom = new int[n+1];
            for(int i = 1; i <= n; i++) { top[i] = fs.nextInt(); }
            for(int i = 1; i <= n; i++) { bottom[i] = fs.nextInt(); }
            int[] perm = new int[n+1];
            for(int i = 1; i <= n; i++) { perm[top[i]] = bottom[i]; }
            boolean[] visited = new boolean[n+1];
            int cycleCounter = 0;
            //little AI help to find the number of cycles. I had almost got it by myself.
            for(int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    cycleCounter++;
                }
                int currentNode = i;
                while(!visited[currentNode]) {
                    visited[currentNode] = true;
                    currentNode = perm[currentNode];
                }
            }
            long ans = 1;
            for(int i = 0; i < cycleCounter; i++) {
                ans = ans * 2 % MOD;
            }
            out.append(ans + "\n");
        }

        System.out.print(out);
    }
}
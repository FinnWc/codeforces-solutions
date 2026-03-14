import java.io.*;
import java.util.*;

public class A_Bingo_Candies {
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
            int[][] board = new int[n][n];
            HashMap<Integer, Integer> seen = new HashMap<>();
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    board[i][j] = fs.nextInt();
                    seen.put(board[i][j], seen.getOrDefault(board[i][j], 0)+1);
                }
            }
            int mostSeen = 0;
            for(int value : seen.values()) {
                if(value > mostSeen) {
                    mostSeen = value;
                }
            }
            if(mostSeen > n*(n-1)) {
                out.append("NO\n");
            } else {
                out.append("YES\n");
            }
        }

        System.out.print(out);
    }
}
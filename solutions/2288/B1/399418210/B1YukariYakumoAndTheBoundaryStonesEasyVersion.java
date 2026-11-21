import java.io.*;
import java.util.*;

public class B1YukariYakumoAndTheBoundaryStonesEasyVersion {
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
            int x = fs.nextInt();
            int y = fs.nextInt();
            int m = fs.nextInt();
            String s = fs.next();
            char[] sChar = s.toCharArray();
            int max = 101;
            boolean[][] dp = new boolean[max][max];
            dp[x][y] = true;
            int ans = x+y;
            for(char c : sChar) {
                boolean[][] next = new boolean[max][max];
                if(c == '-') {
                    for(int i = 0; i < max; i++) {
                        for(int j = 0; j < max; j++) {
                            if(dp[i][j] && i > 0) {
                                next[i-1][j] = true;
                            }
                            if(dp[i][j] && j > 0) {
                                next[i+1][j-1] = true;
                            }
                        }
                    }
                    dp = next;
                } else {
                    for(int i = 0; i < max; i++) {
                        for(int j = 0; j < max; j++) {
                            if(dp[i][j] && i > 0) {
                                next[i-1][j+1] = true;
                            }
                            if(dp[i][j] && j > 0) {
                                next[i][j+1] = true;
                            }
                        }
                    }
                    dp = next;
                }
                for(int i = 0; i < max; i++) {
                    for(int j = 0; j < max; j++) {
                        if(dp[i][j]) {
                            ans = Math.max(ans, i+j);
                        }
                    }
                }
            }
            out.append(ans).append("\n");
        }

        System.out.print(out);
    }
}
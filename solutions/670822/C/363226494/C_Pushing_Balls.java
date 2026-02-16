import java.io.*;
import java.util.*;

public class C_Pushing_Balls {
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
            int m = fs.nextInt();
            int[][] grid = new int[n][m];
            
            boolean noWork = false;
            for(int i = 0; i < n; i++) {
                String row = fs.next();
                for(int j = 0; j < m; j++) {
                    grid[i][j] = row.charAt(j) - '0';
                    if(grid[i][j] == 1 && i > 0 && j > 0) {
                        boolean completableRight = true;
                        boolean completableTop = true;
                        for(int k = i-1; k >= 0; k--) {
                            if(grid[i][j] == 1 && (grid[k][j] == 0)) {
                                completableRight = false;
                                break;
                            }
                        }
                        for(int l = j-1; l >= 0 ; l--) {
                            if(grid[i][j] == 1 && (grid[i][l] == 0)) {
                                completableTop = false;
                                break;
                            }
                        }
                        if(completableRight == false && completableTop == false) {
                            noWork = true;
                        }
                    }
                }
            }
            if(noWork) {
                out.append("NO\n");
            } else {
                out.append("YES\n");
            }
        }
        System.out.print(out);
    }
}

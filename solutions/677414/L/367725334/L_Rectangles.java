import java.io.*;
import java.util.*;

public class L_Rectangles {
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

        int n = fs.nextInt();
        int m = fs.nextInt();
        int[][] grid = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = fs.nextInt();
            }
        }
        long numSets = 0;
        int white = 0;
        int black = 0;
        long[] powers = new long[51];
        //another optimization that AI helped me realize, this is smart, will use this more
        powers[0] = 1;
        for(int i = 1; i <= 50; i++) {
            powers[i] = powers[i-1] * 2;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    white++;
                } else {
                    black++;
                }
            }
            //ai hints helped me figure out the following equation
            numSets += (powers[white]-1) + (powers[black]-1);
            white = 0;
            black = 0;
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[j][i] == 0) {
                    white++;
                } else {
                    black++;
                }
            }
            numSets += (powers[white]-1) + (powers[black]-1);
            black = 0;
            white = 0;
        }
        numSets -= n * m;
        out.append(numSets);
        System.out.print(out);
    }
}
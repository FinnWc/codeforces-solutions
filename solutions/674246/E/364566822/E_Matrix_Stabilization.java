import java.io.*;
import java.util.*;

public class E_Matrix_Stabilization {
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
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    matrix[i][j] = fs.nextInt();
                }
            }
            //I made a working solution, but was curious how I could avoid using a bunch of if/else statements
            //to make sure that I don't get an indexOutOfBounds error, so I was helped in finding the below logic 
            //from AI. I understand it. 
            int[] dr = {-1,1,0,0};
            int[] dc = {0,0,-1,1};
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    int mx = Integer.MIN_VALUE;
                    for(int k = 0; k < 4; k++) {
                        int ni = i + dr[k], nj = j + dc[k];
                        if(0 <= ni && ni < n && 0 <= nj && nj < m) {
                            mx = Math.max(mx, matrix[ni][nj]);
                        }
                    }
                    if (matrix[i][j] > mx) matrix[i][j] = mx;
                    out.append(matrix[i][j]).append(" ");
                }
                out.append("\n");
            }
        }

        System.out.print(out);
    }
}

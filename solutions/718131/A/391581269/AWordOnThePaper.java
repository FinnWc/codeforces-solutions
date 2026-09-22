import java.io.*;
import java.util.*;

public class AWordOnThePaper {
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
            String[] grid = new String[8];
            for(int i = 0; i < 8; i++) {
                grid[i] = fs.next();
            }
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                    if(grid[i].charAt(j) !='.') {
                        out.append(grid[i].charAt(j));
                    }
                }
            }
            out.append("\n");
         }

        System.out.print(out);
    }
}
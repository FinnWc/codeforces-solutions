import java.io.*;
import java.util.*;

public class DVasyaAndCornfield {
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
        int d = fs.nextInt();
        int m = fs.nextInt();
        int[] x = new int[m];
        int[] y = new int[m];
        for(int i = 0; i < m; i++) { 
            x[i] = fs.nextInt(); 
            y[i] = fs.nextInt();
        }
        int tx, ty;
        for(int i = 0; i < m; i++) {
            tx = x[i];
            ty = y[i];
            //had the original conditions almost correct, made a small math error, helped fix with AI 
            if(tx + ty >= d && tx + ty <= 2*n-d && tx-ty<=d &&  ty-tx<=d) {
                out.append("YES\n");
            } else {
                out.append("NO\n");
            }
        }

        System.out.print(out);
    }
}
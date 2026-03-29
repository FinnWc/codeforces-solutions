import java.io.*;
import java.util.*;

public class E_Diamond_Miner {
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
            //I kept trying to get this working with a 2d array grid, but AI hint made me realize two arrays is the best option
            //for handling the input
            long[] miners = new long[n];
            long[] diamonds = new long[n];
            int minerIndex = 0;
            int diamondIndex = 0;
            for(int i = 0; i < 2 * n; i++) {
                long x = fs.nextLong();
                long y = fs.nextLong();
                if(x == 0) {
                    miners[minerIndex++] = Math.abs(y);
                } else {
                    diamonds[diamondIndex++] = Math.abs(x);
                }
            }
            //the sorting and maching step was also a coralary of having AI help me figure out the above realization.
            Arrays.sort(miners);
            Arrays.sort(diamonds);
            double ans = 0;
            for(int i = 0; i < n; i++) {
                ans += Math.sqrt(Math.pow(miners[i], 2) + Math.pow(diamonds[i], 2));
            }
            out.append(ans).append("\n");
        }

        System.out.print(out);
    }
}
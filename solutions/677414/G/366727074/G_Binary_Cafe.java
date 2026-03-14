import java.io.*;
import java.util.*;

public class G_Binary_Cafe {
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
            int k = fs.nextInt();
            long ans;
            if (k >= 31) {
                ans = n + 1;
            } else {
                //had the exact right answer but kept running into overflow issues, couldn't figure it out
                //tried a few different things but couldn't get it. AI helped me realize that the problem was overflow and how I could 
                //solve it. I understand this. Solution is not something I would've realized on my own I don't think. 
                ans = Math.min(n + 1, 1L << k);
            }
            out.append(ans).append("\n");
        }
        

        System.out.print(out);
    }
}
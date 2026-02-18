import java.io.*;
import java.util.*;

public class A_Destroying_Bridges {
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
            int answer = n;
            //kept trying wrong brute force approach, AI helped me realize the following:
            for(int i = 1; i < n; i++) {
                if(i*(n-i) <= k) {
                    answer = i;
                    break;
                }
            }
            out.append(answer + "\n");
        }

        System.out.print(out);
    }
}
import java.io.*;
import java.util.*;

public class DBlackAndWhiteStripe {
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
            String s = fs.next();
            char[] sChar = s.toCharArray();
            int rTotalBlack = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < k; i++) {
                if(sChar[i] == 'B') {
                    rTotalBlack++;
                }
            }
            min = Math.min(k-rTotalBlack, min);
            for(int i = 1; i <= n-k; i++) {
                if(sChar[i-1] == 'B') {
                    rTotalBlack--;
                }
                if(sChar[i+k-1] == 'B') {
                    rTotalBlack++;
                }
                min = Math.min(k-rTotalBlack, min);
            }
            out.append(min).append("\n");
        }

        System.out.print(out);
    }
}
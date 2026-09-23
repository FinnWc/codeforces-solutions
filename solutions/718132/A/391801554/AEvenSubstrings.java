import java.io.*;
import java.util.*;

public class AEvenSubstrings {
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
        String s = fs.next();
        char[] sChar = s.toCharArray();
        int count = 0;
        for(int i = 0; i < n; i++) {
            if((sChar[i] - '0') % 2 == 0) {
                count += i+1;
            }
        }
        out.append(count);

        System.out.print(out);
    }
}
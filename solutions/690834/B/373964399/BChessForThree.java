import java.io.*;
import java.util.*;

public class BChessForThree {
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
            int p1 = fs.nextInt();
            int p2 = fs.nextInt();
            int p3 = fs.nextInt();
            if((p1 + p2 + p3) % 2 != 0) {
                out.append(-1).append("\n");
                continue;
            }
            int firstTwoTotal = p1 + p2;
            out.append(Math.min((p1 + p2 + p3)/2,p1+p2)).append("\n");
        }

        System.out.print(out);
    }
}
import java.io.*;
import java.util.*;

public class ANumbersOnTheBoard {
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
            int l = fs.nextInt();
            int r = fs.nextInt();
            int n = r-l;
            if(l <= 0 && r >= 0) {
                n++;
            }
            if(l == r) { //equal
                out.append(0);
            } else if(l > 0 && r > 0) { //both positive
                out.append(n);
            } else if(l == 0 && r > 0) { //one 0, one positive
                out.append(n-2);
            } else if(l < 0 && r > 0) { //one negative, one positive
                if(l+r == 0 || Math.abs(l+r) == 1) {
                    out.append(0);
                } else {
                    out.append(Math.abs(l+r)-1);
                }
            } else if(l < 0 && r < 0) { //both negative
                out.append(n);
            } else if(l < 0 && r == 0) { //one negative, one 0
                out.append(n-2);
            }
            out.append("\n");
        }

        System.out.print(out);
    }
}
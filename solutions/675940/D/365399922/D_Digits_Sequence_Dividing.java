import java.io.*;
import java.util.*;

public class D_Digits_Sequence_Dividing {
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

        int q = fs.nextInt();
        while(q-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            int firstDig = s.charAt(0) - '0';
            int rest;
            if(s.length() > 2) {
                rest = Integer.parseInt(s.substring(1,3));
            } else {
                rest = Integer.parseInt(s.substring(1));
            }
            if(firstDig < rest) {
                out.append("YES\n").append("2\n").append(firstDig + " " + s.substring(1) + "\n");
            } else {
                out.append("NO\n");
            }
        }

        System.out.print(out);
    }
}
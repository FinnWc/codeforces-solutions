import java.io.*;
import java.util.*;

public class ENnAndTheOpticalIllusion {
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
        int r = fs.nextInt();
        //AI hint helped me realize there was a triangle, solved the rest from there
        double R = r*Math.sin(Math.PI/n) / (1-Math.sin(Math.PI/n));
        out.append(R);
        System.out.print(out);
    }
}